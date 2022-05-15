package lotto.domain;

import lotto.message.InputMessage;

public class Money {
    public static final int MINIMUM_MONEY = 1000;
    private final int money;

    public Money(int money) {
        validateMinimum(money);
        this.money = money;
    }

    private void validateMinimum(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException(InputMessage.INVALID_MINIMUM_MONEY);
        }
    }

    public int getMoney() {
        return money;
    }
}
