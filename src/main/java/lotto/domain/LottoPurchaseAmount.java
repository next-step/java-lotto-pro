package lotto.domain;

import lotto.common.ErrorMessage;

public class LottoPurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int PURCHASE_AMOUNT_MAX = 200000;
    private final int quantity;

    public LottoPurchaseAmount(int money) {
        this.quantity = this.validate(money);
    }

    private int validate(int money) {
        if (!isPositiveNumber(money)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_AMOUNT_RANGE);
        }
        if (isOverPurchaseAmount(money)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_AMOUNT_MAX);
        }
        return money / LOTTO_PRICE;
    }

    public LottoPurchaseAmount pay(int purchaseCount) {
        return new LottoPurchaseAmount((this.quantity - purchaseCount) * LOTTO_PRICE);
    }

    private boolean isPositiveNumber(int number) {
        return number >= 0;
    }

    private boolean isOverPurchaseAmount(int money) {
        return money > PURCHASE_AMOUNT_MAX;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
