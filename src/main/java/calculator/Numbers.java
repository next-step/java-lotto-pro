package calculator;

import java.util.Arrays;

public class Numbers {
    private final int[] numbers;
    private static final int MIN_VALUE = 0;

    public Numbers(String[] numbers) {
        this.numbers = createNumbers(numbers);
        negativeNumberCheck();
    }

    public int sumNumbers() {
        return Arrays.stream(numbers).sum();
    }

    private int[] createNumbers(String[] inputs) {
        try {
            return Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }

    private void negativeNumberCheck() {
        boolean isNegative = Arrays.stream(numbers).anyMatch(number -> number < MIN_VALUE);
        if (isNegative) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Arrays.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }
}
