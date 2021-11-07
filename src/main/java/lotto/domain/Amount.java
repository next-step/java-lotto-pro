package lotto.domain;

public class Amount {

    protected final long amount;

    public Amount(long amount) {
        this.amount = amount;
    }

    public double divideToDouble(Amount otherAmount) {
        return (double)this.amount / (double) otherAmount.amount;
    }
}
