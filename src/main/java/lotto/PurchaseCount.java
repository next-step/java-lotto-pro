package lotto;

import java.util.Objects;

public class PurchaseCount {
    private final int purchaseCount;

    public PurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseCount that = (PurchaseCount) o;
        return purchaseCount == that.purchaseCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseCount);
    }
}
