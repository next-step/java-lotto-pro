package lotto.domain;

import lotto.view.Error;
import lotto.view.OutputView;

public class Money {
    private final int money;

    public Money(int money) {
        if (!isValid(money)) {
            throw new IllegalArgumentException(Error.MONEY);
        }
        this.money = money;
    }

    public static boolean isValid(int money) {
        if (money < 0) {
            OutputView.print(Error.MONEY_ALLOW_POSITIVE);
            return false;
        }
        if (money % Lotto.LOTTO_PRICE != 0) {
            OutputView.print(Error.MONEY_UNIT);
            return false;
        }
        return true;
    }

    public int getBuyableLottoCount() {
        return this.money / Lotto.LOTTO_PRICE;
    }
}
