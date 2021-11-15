package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Number implements Comparable<Number> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, Number> numbers = new HashMap<>();
    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.put(i, new Number(i));
        }
    }

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        return Optional.ofNullable(numbers.get(number))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "의 숫자만 입력 가능합니다. (입력값: " + number + ")"));
    }


    @Override
    public int compareTo(Number number) {
        return Integer.compare(this.number, number.number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
