package lotto.model.money;

import java.util.Objects;

public class Money {
    private final double value;

    private Money(double value) {
        this.value = value;
    }

    public static Money from(double value) {
        return new Money(value);
    }

    public double divide(Money money) {
        if (money.value == 0) {
            return 0;
        }
        return Math.floor((this.value / money.value) * 100) / 100;
    }

    public Money multiply(double count) {
        return Money.from(value * count);
    }

    public Money add(Money money) {
        return Money.from(value + money.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Double.compare(money.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf((int) value);
    }
}
