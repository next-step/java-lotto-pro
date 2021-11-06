package lotto.domain.number;

import lotto.exception.OutOfBoundException;

public class Money extends Number {
    public static final int ZERO = 0;

    protected Money(final int money) {
        super(money);
        validate(money);
    }

    public static Money from(int money) {
        return new Money(money);
    }

    @Override
    protected void validate(final int money) {
        if (money < ZERO) {
            throw OutOfBoundException.valueIsLessThan(money);
        }
    }

    public long multiply(int count) {
        return number() * ((long) count);
    }
}
