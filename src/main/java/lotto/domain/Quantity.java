package lotto.domain;

public class Quantity {
    private final int quantity;
    private final int maxQuantity;
    private final int manualQuantity;

    public Quantity(int maxQuantity, int manualQuantity) {
        this(manualQuantity, maxQuantity, manualQuantity);
    }

    private Quantity(int quantity, int maxQuantity, int manualQuantity) {
        validate(quantity, maxQuantity);
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
        this.manualQuantity = manualQuantity;
    }

    private void validate(int quantity, int maxQuantity) {
        if (quantity > maxQuantity) {
            throw new IllegalArgumentException(String.format("구매할 수 있는 수량을 초과하였습니다. 구매가능수량: %d, 구매수량:%d", maxQuantity, quantity));
        }
    }

    public Quantity increase() {
         return new Quantity(this.quantity + 1, maxQuantity, manualQuantity);
    }

    public boolean isPurchasable() {
        return maxQuantity > quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }
}
