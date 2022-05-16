package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.common.PositiveNumber;

import java.util.Objects;

public class Money {
    private static final int MIN_VALUE = 0;

    private final PositiveNumber amount;

    public Money(PositiveNumber amount) {
        this.amount = amount;
    }

    public Money (long amount) {
        this(new PositiveNumber(amount));
    }

    public Money (String amount) {
        this(new PositiveNumber(amount, false));
    }

    public PositiveNumber availablePurchaseCount(Money price) {
        return this.amount.divideAndGetShare(price.amount);
    }

    public Money add(Money target) {
        if (target.amount.getValue() == 0) {
            return this;
        }
        return new Money(this.amount.add(target.amount));
    }

    public Money subtract(Money target) {
        return new Money(this.amount.subtract(target.amount));
    }

    public Money multiply(PositiveNumber multipleValue) {
        return new Money(this.amount.multiply(multipleValue));
    }

    public double calculateRateByOtherMoney(Money target) {
        return (double)this.amount.getValue() / target.amount.getValue();
    }

    public boolean isGreater(Money target) {
        return this.amount.getValue() > target.amount.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN_VALUE, amount);
    }

    @Override
    public String toString() {
        return this.amount + "원";
    }
}
