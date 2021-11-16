package lotto.domain;

import java.util.Objects;

public class Money {

    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public long divide(long amount) {
        if (amount <= 0 ) {
            throw new ArithmeticException("금액은 0원 이상이여야 합니다.");
        }
        return this.amount / amount;
    }

    public double rate(long amount) {
        if (amount == 0) {
            return 0;
        }
        return (double) amount / this.amount;
    }

    public void add(long amount) {
        this.amount += amount;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
