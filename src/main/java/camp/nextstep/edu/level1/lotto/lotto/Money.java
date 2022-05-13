package camp.nextstep.edu.level1.lotto.lotto;

import java.util.Objects;

public class Money {
    private static final int MIN_VALUE = 0;

    private final long amount;

    public Money(long amount) {
        checkValidateMoney(amount);
        this.amount = amount;
    }

    public long availablePurchaseCount(long price) {
        checkPurchasePrice(price);
        return this.amount / price;
    }

    public Money add(Money target) {
        if (target.amount == 0) {
            return this;
        }
        return new Money(this.amount + target.amount);
    }

    public Money subtract(Money target) {
        checkSubValidate(target.amount);

        return new Money(this.amount - target.amount);
    }

    public Money multiply(int multipleValue) {
        return new Money(this.amount * multipleValue);
    }

    public double calculateRateByOtherMoney(Money target) {
        return (double)this.amount / target.amount;
    }

    private void checkValidateMoney(long value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("금액은 양수 값이어야 합니다.");
        }
    }

    private void checkSubValidate(long value) {
        if (this.amount - value < MIN_VALUE) {
            throw new IllegalArgumentException("0원 미만으로 만들 수 없습니다.");
        }
    }

    private void checkPurchasePrice(long price) {
        if (price <= 0) {
            throw new IllegalArgumentException("0원 초과의 물건만 구입할 수 있습니다.");
        }
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
        return Objects.hash(MIN_VALUE, amount);
    }

    @Override
    public String toString() {
        return this.amount + "원";
    }
}
