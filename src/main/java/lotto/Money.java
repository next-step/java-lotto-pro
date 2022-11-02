package lotto;

import lotto.common.LottoAutoUtils;

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
            throw new IllegalArgumentException("소유한 금액이 로또 최소금액보다 적습니다.");
        }
        this.money = this.money - subtractMoney;

        return this.money;
    }
}
