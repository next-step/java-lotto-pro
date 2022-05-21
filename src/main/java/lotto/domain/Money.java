package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int MIN = 0;
    private final long value;

    private Money(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < MIN) {
            throw new IllegalArgumentException(String.format("돈은 %d보다 작을 수 없습니다.", MIN));
        }
    }

    public static Money from(long money) {
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

    public double divide(Money money) {
        return (double) this.value / money.value;
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
