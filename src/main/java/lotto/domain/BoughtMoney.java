package lotto.domain;

import lotto.exception.InvalidMoneyException;

import static lotto.common.LottoConst.LOTTO_PRICE;

public class BoughtMoney {
    private int money;

    public BoughtMoney(int money) {
        this.money = money;
        validMoney();
    }

    private void validMoney() {
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

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
