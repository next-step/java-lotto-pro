package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

public class Money {
    private static final int MONEY_MIN = 0;
    private final long value;

    public Money(final long money) {
        validate(money);
        this.value = money;
    }

    public long getValue() {
        return value;
    }

    private void validate(final long money) {
        if (money < MONEY_MIN) {
            throw new LottoException(LottoExceptionType.MINUS_MONEY);
        }
    }
}
