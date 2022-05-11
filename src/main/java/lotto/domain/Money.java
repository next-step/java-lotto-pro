package lotto.domain;

import static lotto.constants.LottoErrorMessage.INVALID_INPUT_MONEY;

public class Money {
    private static final int MONEY_MIN = 0;
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money){
        validateMoney(money);
        return new Money(money);
    }

    private static void validateMoney(int money) {
        if(money >= MONEY_MIN){
            return;
        }

        throw new IllegalArgumentException(
            String.format(INVALID_INPUT_MONEY, money)
        );
    }

    public int getMoney() {
        return this.money;
    }
}
