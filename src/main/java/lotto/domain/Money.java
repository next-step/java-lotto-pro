package lotto.domain;

import java.util.Objects;

public class Money {
    public static final long ZERO = 0L;

    private long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("돈은 0보다 커야 합니다");
        }
    }

    public long value() {
        return this.value;
    }

    public double divide(Money money) {
        return (double) value / money.value;
    }

    public Money sum(Money other) {
        return new Money(this.value + other.value);
    }

    public Money multiply(int count) {
        return new Money(value * count);
    }

    public Money subtract(Money money) {
        return new Money(this.value - money.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
