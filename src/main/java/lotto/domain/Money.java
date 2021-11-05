package lotto.domain;

import lotto.exception.NegativeMoneyException;

public class Money {
    public static final int ZERO = 0;
    private final int money;

    public Money(int money) {
        checkMoneyNegative(money);
        this.money = money;
    }

    private void checkMoneyNegative(int money) {
        if (money < ZERO) {
            throw new NegativeMoneyException();
        }
    }
}
