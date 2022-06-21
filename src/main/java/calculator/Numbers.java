package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private static final String NULL_WAS_ENTERED = "정수가 입력되지 않았습니다.";

    private final List<Number> numbers = new LinkedList<>();

    public Numbers() {
    }

    public Numbers(String[] numbers) {
        if (numbers == null) {
            throw new NullPointerException(NULL_WAS_ENTERED);
        }
        for (String number : numbers) {
            this.numbers.add(new Number(number));
        }
    }

    public int sum() {
        return numbers.stream()
                      .mapToInt(Number::value)
                      .sum();
    }

    public List<Number> list() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
