package lotto.domain;

import static lotto.constants.ExceptionConstants.*;

public class Money {
    private static final int ZERO = 0;
    private final long value;

    public Money(final long money) {
        validate(money);
        this.value = money;
    }

    public long getValue() {
        return value;
    }

    private void validate(final long money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(MINUS_MONEY__EXCEPTION);
        }
    }
}
