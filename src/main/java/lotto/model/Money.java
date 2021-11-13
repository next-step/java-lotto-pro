package lotto.model;

import java.util.Objects;

public class Money {
    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public double divideBy(Money money) {
        return (double) this.money / money.money;
    }

    public boolean isZero() {
        return money == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.money == money.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public Money multiplyBy(int multiplier) {
        return new Money(this.money * multiplier);
    }

    public Money plus(Money money) {
        return new Money(this.money + money.money);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
