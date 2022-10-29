package step3.domain;

public class PurchasingAmount {

    private final Amount amount;

    public PurchasingAmount(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "PurchasingAmount{" +
                "amount=" + amount +
                '}';
    }
}
