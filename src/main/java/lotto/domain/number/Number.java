package lotto.domain.number;

import java.util.Objects;

public abstract class Number {
    private final int number;

    protected Number(final int number) {
        this.number = number;
    }

    protected abstract void validate(int number);

    public int number() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
