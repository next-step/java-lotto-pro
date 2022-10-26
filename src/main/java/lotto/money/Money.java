package lotto.money;

import lotto.message.ErrorMessages;

public class Money {
    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money from(int value) {
        return new Money(value);
    }

    public int divide(Money money) {
        if (money.value == 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DENOMINATOR_VALUE);
        }
        return this.value / money.value;
    }
}
