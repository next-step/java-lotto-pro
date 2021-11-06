package lotto.model;

import java.util.Objects;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int divideBy(Money money) {
        return this.value / money.value;
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
}
