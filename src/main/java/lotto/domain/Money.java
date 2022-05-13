package lotto.domain;

import static lotto.messages.ErrorMessages.MONEY_NEGATIVE_ERROR;
import static lotto.messages.ErrorMessages.ZERO_DIVIDE_ERROR;

public class Money {

    private int money;

    private Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int divide(int divisor) {
        if (divisor == 0) throw new IllegalArgumentException(ZERO_DIVIDE_ERROR);
        return money/divisor;
    }
}
