package lotto.domain;

import lotto.common.ErrorMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int PURCHASE_AMOUNT_MAX = 200000;
    private final int value;

    public Money(int values) {
        this.value = this.validate(values);
    }

    private int validate(int money) {
        if (!isPositiveNumber(money)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_AMOUNT_RANGE);
        }
        if (isOverPurchaseAmount(money)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_AMOUNT_MAX);
        }
        return money;
    }

    public boolean canBuy() {
        return this.value >= LOTTO_PRICE;
    }

    public Money pay(Money purchaseAmount) {
        return new Money(this.value - purchaseAmount.value);
    }

    public Money payForTickets(int ticketsCount) {
        return new Money(this.value - ticketsCount * LOTTO_PRICE);
    }

    private boolean isPositiveNumber(int number) {
        return number >= 0;
    }

    private boolean isOverPurchaseAmount(int money) {
        return money > PURCHASE_AMOUNT_MAX;
    }

    public int getValues() {
        return this.value;
    }
}
