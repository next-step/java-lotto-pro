package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class BoughtLotto {
    private static final int LOTTO_PRICE = 1000;

    private int boughtMoney;

    public BoughtLotto(final int money) {
        validMoney(money);
        this.boughtMoney = money;
    }

    private void validMoney(final int money) {
        if (!isThousandUnit(money) || !isPositiveInteger(money)) {
            throw new InvalidMoneyException();
        }
    }

    private boolean isThousandUnit(final int money) {
        return money % LOTTO_PRICE == 0;
    }

    private boolean isPositiveInteger(final int money) {
        return money > 0;
    }

    public int getBoughtCount() {
        return this.boughtMoney / LOTTO_PRICE;
    }
}
