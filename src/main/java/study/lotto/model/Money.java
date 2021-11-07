package study.lotto.model;

import study.lotto.model.exception.NotEnoughMoneyException;

public class Money {

    private static final String ORDER_MONEY_NOT_ENOUGH_ERROR_MESSAGE = "최소 1000 이상의 값이어야 합니다.";
    private static final int MINIMUM_MONEY = 1000;

    private final int money;

    private Money(final int money) {
        validate(money);
        this.money = money;
    }

    private void validate(final int money) {
        if (money < MINIMUM_MONEY) {
            throw new NotEnoughMoneyException(ORDER_MONEY_NOT_ENOUGH_ERROR_MESSAGE);
        }
    }

    public static Money valueOf(final int money) {
        return new Money(money);
    }

    public int getMoney() {
        return money;
    }

    public int divide(final int priceOfLottoTicket) {
        return money / priceOfLottoTicket;
    }
}
