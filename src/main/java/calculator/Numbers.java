package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private static String NULL_WAS_ENTERED = "정수가 입력되지 않았습니다.";

    private final List<Number> numbers = new LinkedList<>();

    public Numbers() {
    }

    public Numbers(String[] integers) {
        if (integers == null) {
            throw new NullPointerException(NULL_WAS_ENTERED);
        }
        for (String integer : integers) {
            numbers.add(new Number(integer));
        }
    }

    public int sum() {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.value();
        }
        return sum;
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
