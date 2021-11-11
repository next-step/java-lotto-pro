package study.lotto.model;

import study.lotto.model.exception.NotEnoughMoneyException;

public class Money {

    private static final String ORDER_MONEY_NOT_ENOUGH_ERROR_MESSAGE = "최소 0 이상의 값이어야 합니다.";
    private static final int MINIMUM_MONEY = 0;

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

    public int divideByPriceOfLottoTicket() {
        return divide(LottoStore.PRICE_OF_LOTTO_TICKET).intValue();
    }

    int intValue() {
        return this.money;
    }

    public Money divide(final Money money) {
        return valueOf(this.money / money.money);
    }

    public boolean greaterThan(final Money money) {
        return this.money >= money.money;
    }

    public Money multiply(final int times) {
        return valueOf(this.money * times);
    }

    public Money minus(Money money) {
        return valueOf(this.money - money.money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return money;
    }
}
