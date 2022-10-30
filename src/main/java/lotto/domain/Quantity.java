package lotto.domain;

public class Quantity {
    private final int manual;
    private final int auto;

    public Quantity(final int manual, final int auto) {
        this.manual = manual;
        this.auto = auto;
    }

    public int getCount(PurchaseType purchaseType) {
        if(purchaseType == PurchaseType.AUTO) {
            return auto;
        }
        return manual;
    }
}
