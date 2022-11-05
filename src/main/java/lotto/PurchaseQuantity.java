package lotto;

import java.util.Objects;

public class PurchaseQuantity {
    private final int purchaseQuantity;

    public PurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseQuantity that = (PurchaseQuantity) o;
        return purchaseQuantity == that.purchaseQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseQuantity);
    }
}
