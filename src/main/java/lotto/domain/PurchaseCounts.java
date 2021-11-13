package lotto.domain;

import java.util.Objects;

public class PurchaseCounts {

    private final PurchaseCount autoPurchaseCount;
    private final PurchaseCount manualPurchaseCount;

    public PurchaseCounts(PurchaseCount autoPurchaseCount, PurchaseCount manualPurchaseCount) {
        this.autoPurchaseCount = autoPurchaseCount;
        this.manualPurchaseCount = manualPurchaseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseCounts that = (PurchaseCounts) o;
        return Objects.equals(autoPurchaseCount, that.autoPurchaseCount) && Objects.equals(manualPurchaseCount, that.manualPurchaseCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoPurchaseCount, manualPurchaseCount);
    }
}
