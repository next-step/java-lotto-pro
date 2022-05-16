package lotto.model;

public class NonAutoPurchaseCount {
    private int count;

    public NonAutoPurchaseCount(int count) {
        this.count = count;
    }

    public long nonAutoPurchasePrice() {
        return (long) this.count * PurchaseStatus.LOTTO_PRICE;
    }
}
