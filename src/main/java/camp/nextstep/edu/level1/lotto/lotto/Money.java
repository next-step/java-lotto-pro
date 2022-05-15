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

    public long availablePurchaseCount(Money price) {
        checkPurchasePrice(price);
        return this.amount.getValue() / price.amount.getValue();
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

    public boolean isSameOrGreater(Money target) {
        return this.amount.getValue() >= target.amount.getValue();
    }

    private void checkPurchasePrice(Money price) {
        if (price.amount.getValue() <= 0) {
            throw new IllegalArgumentException("0원 초과의 물건만 구입할 수 있습니다.");
        }
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
