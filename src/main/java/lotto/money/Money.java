package lotto.money;

import lotto.message.ErrorMessages;

public class Money {
    private final double value;

    private Money(double value) {
        this.value = value;
    }

    public static Money from(double value) {
        return new Money(value);
    }

    public double divide(Money money) {
        if (money.value == 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DENOMINATOR_VALUE);
        }
        return Math.floor((this.value / money.value) * 100) / 100;
    }
}
