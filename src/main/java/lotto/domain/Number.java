package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    public Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "의 숫자만 입력 가능합니다. (입력값: " + number + ")");
        }
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
    public int compareTo(Number number) {
        return Integer.compare(this.number, number.number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
