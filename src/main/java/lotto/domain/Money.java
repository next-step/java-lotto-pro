package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int ZERO = 0;
    private final int value;

    private Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException(String.format("돈은 %d보다 작을 수 없습니다.",ZERO));
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public boolean isMoreThanOrEqual(Money money) {
        return this.value >= money.value;
    }

    public Money plus(Money money) {
        return new Money(this.value + money.value);
    }

    public Money minus(Money money) {
        return new Money(this.value - money.value);
    }

    public Money multiply(int count) {
        return new Money(this.value * count);
    }

    public double calculateLottoYield(Money winningReward) {
        return (double) this.value / winningReward.value;
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
