package step3.model;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("숫자의 범위는 1~45 사이어야 합니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override public int hashCode() {
        return Objects.hash(number);
    }

    @Override public int compareTo(Number o) {
        return Integer.compare(this.number, o.number);
    }
}
