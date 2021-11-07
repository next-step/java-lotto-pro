package lotto.model;

import java.util.Objects;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public double divideBy(Money money) {
        return (double) this.value / money.value;
    }

    public boolean isZero() {
        return value == 0;
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

    public Money multiplyBy(int value) {
        return new Money(this.value * value);
    }

    public Money plus(Money money) {
        return new Money(this.value + money.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
