package lotto.model.vo;

import java.util.Objects;
import lotto.model.constants.ErrorMessage;

public class PurchaseCount {

    long purchaseCount;

    public PurchaseCount(long purchaseCount) {
        if (!validatePositive(purchaseCount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_COUNT_MUST_POSITIVE);
        }
        this.purchaseCount = purchaseCount;
    }

    private boolean validatePositive(long purchaseCount) {
        return purchaseCount > 0;
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

    public long getPurchaseCount() {
        return purchaseCount;
    }
}
