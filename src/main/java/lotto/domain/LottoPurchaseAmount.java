package lotto.domain;

import lotto.common.ErrorMessage;

import java.net.InetAddress;

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
        if (!isPurchaseAmountUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_AMOUNT_UNIT);
        }
        return money / LOTTO_PRICE;
    }

    private boolean isPositiveNumber(int money) {
        return money > 0;
    }

    private boolean isOverPurchaseAmount(int money) {
        return money > PURCHASE_AMOUNT_MAX;
    }

    private boolean isPurchaseAmountUnit(int money) {
        return money % LOTTO_PRICE == 0;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
