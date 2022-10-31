package lotto.auto;

import lotto.auto.common.LottoAutoUtils;

public class Money {
    private final int DEFAULT_MONEY = 0;
    private int money;

    public Money() {
        this.money = DEFAULT_MONEY;
    }

    public Money(String money) {
        this.money = new LottoAutoUtils().stringToNumber(money);
    }

    public int getMoney() {
        return money;
    }

    public int substractMoney(String subtract) {
        int subtractMoney = new LottoAutoUtils().stringToNumber(subtract);
        if (this.money < subtractMoney) {
            throw new IllegalArgumentException();
        }
        this.money = this.money - subtractMoney;

        return this.money;
    }
}
