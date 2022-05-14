package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

public class Money {
    private static final int MIN_MONEY = 0;
    private final int money;

    public Money(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_MIN_MONEY);
        }
        this.money = money;
    }

    public int purchaseCount() {
        int purchaseCount = this.money / Constants.LOTTO_PRICE;
        if (purchaseCount > Constants.MAX_PURCHASE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.MAX_PURCHASE_LOTTO);
        }
        return purchaseCount;
    }
}
