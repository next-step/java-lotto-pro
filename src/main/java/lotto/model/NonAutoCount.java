package lotto.model;

public class NonAutoCount {
    private int count;

    public NonAutoCount(int count) {
        this.count = count;
    }

    public long nonAutoPurchasePrice() {
        return (long) this.count * PurchaseStatus.LOTTO_PRICE;
    }
}
