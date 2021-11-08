package lotto.domain;

import java.util.Objects;

public class Amount {

    private static final int MIN_AMOUNT = 0;
    private static final String ILLEGAL_AMOUNT_ERROR_MESSAGE = "적절하지 않은 금액입니다.";
    protected final long amount;

    public Amount(long amount) {
        validatePurchaseAmount(amount);
        this.amount = amount;
    }

    private void validatePurchaseAmount(long amount) {
        if(amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(ILLEGAL_AMOUNT_ERROR_MESSAGE);
        }
    }

    public long divide(Amount otherAmount) {
        return this.amount / otherAmount.amount;
    }

    public double divideToDouble(Amount otherAmount) {
        return (double)this.amount / (double) otherAmount.amount;
    }

    public Amount subtract(Amount subtractAmount) {
        return new Amount(this.amount - subtractAmount.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
