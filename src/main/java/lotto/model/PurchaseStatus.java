package lotto.model;

public class PurchaseStatus {
    public final static int LOTTO_PRICE = 1000;

    private final NonAutoCount nonAutoCount;
    private final PurchasePrice purchasePrice;

    public PurchaseStatus(int nonAutoCount, long purchaseprice) {
        this.nonAutoCount = new NonAutoCount(nonAutoCount);
        this.purchasePrice = new PurchasePrice(purchaseprice);
    }


}
