package lotto.vo;

import java.util.*;

public class Lottery {
    public final static int LOTTERY_MINIMUM_NUMBER = 1;
    public final static int LOTTERY_MAXIMUM_NUMBER = 45;
    public final static int LOTTERY_SIZE = 6;

    private final static String LOTTERY_NUMBERS_WERE_NOT_GENERATED = "로또 번호가 생성되지 않았습니다.";
    private final static String LOTTERY_NUMBERS_WERE_OUT_OF_RANGE = "로또 번호 범위에 벗어난 숫자입니다.";

    private List<Number> numbers;

    public Lottery() {
    }

    public Lottery(List<Number> numbers) {
        if (isNull(numbers)) {
            throw new NullPointerException(LOTTERY_NUMBERS_WERE_NOT_GENERATED);
        }
        if (isInsufficientSize(numbers)) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_WERE_NOT_GENERATED);
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_WERE_OUT_OF_RANGE);
        }
        this.numbers = numbers;
    }

    private boolean isNull(List<Number> numbers) {
        return numbers == null;
    }

    private boolean isInsufficientSize(List<Number> numbers) {
        Set<Number> set = new HashSet<>(numbers);
        return set.size() < LOTTERY_SIZE || set.size() > LOTTERY_SIZE;
    }

    private boolean isOutOfRange(List<Number> numbers) {
        int idx = 0;
        int size = numbers.size();
        boolean result = false;
        while (!result && idx < size) {
            result = isUnderFlowOrOverFlow(numbers.get(idx++));
        }
        return result;
    }

    private boolean isUnderFlowOrOverFlow(Number number) {
        return number.value() < LOTTERY_MINIMUM_NUMBER || number.value() > LOTTERY_MAXIMUM_NUMBER;
    }

    public List<Number> list() {
        return numbers;
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numbers=" + numbers +
                '}';
    }

    public String customToString() {
        int[] numbers = new int[this.numbers.size()];
        int idx = 0;
        for (Number number : this.numbers) {
            numbers[idx++] = number.value();
        }
        return Arrays.toString(numbers);
    }
}
