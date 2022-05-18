package lotto.domain;

import static lotto.constants.ExceptionConstants.*;

public class Money {
    private static final int ZERO = 0;
    private final long money;

    public Money(final long money) {
        validate(money);
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    private void validate(final long money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(LOTTO_MONEY_LEAK_EXCEPTION);
        }
    }
}
