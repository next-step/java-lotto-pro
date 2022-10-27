package step2;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(int value) {
        if (value < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        this.value = value;
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value);
    }

    public int value() {
        return value;
    }

    public static Number sum(Number a, Number b) {
        return a.plus(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
