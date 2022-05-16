package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoErrorMessage.INVALID_INPUT_MONEY;

public class Money {
    private static final int MONEY_MIN = 0;
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        if (money < MONEY_MIN) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_MONEY, money));
        }

        return new Money(money);
    }

    public int getMoney() {
        return this.money;
    }

    public LottoCount calculateLottoCount() {
        return LottoCount.from(this.money / LOTTO_PRICE);
    }
}
