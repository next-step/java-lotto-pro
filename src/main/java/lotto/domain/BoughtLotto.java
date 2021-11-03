package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class BoughtLotto {
    private static final int LOTTO_PRICE = 1000;

    private int boughtMoney;

    public BoughtLotto(int money) {
        validMoney(money);
        this.boughtMoney = money;
    }

    private void validMoney(int money) {
        if (!isThousandUnit(money) || !isPositiveInteger(money)) {
            throw new InvalidMoneyException();
        }
    }

    private boolean isThousandUnit(int money) {
        return money % LOTTO_PRICE == 0;
    }

    private boolean isPositiveInteger(int money) {
        return money > 0;
    }

    public int getBoughtCount() {
        return this.boughtMoney / LOTTO_PRICE;
    }
}
