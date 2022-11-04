package lotto.domain;

import lotto.view.Error;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public static void validate(int money) throws IllegalArgumentException {
        if (money < 0) {
            throw new IllegalArgumentException(Error.MONEY_ALLOW_POSITIVE);
        }
        if (money % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.MONEY_UNIT);
        }
    }

    public int getBuyableLottoCount() {
        return this.money / Lotto.LOTTO_PRICE;
    }
}
