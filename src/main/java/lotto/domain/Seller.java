package lotto.domain;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;

public class Seller {
    private static final int LOTTO_MONEY_AMOUNT = 1_000;

    private Seller() {
    }

    public static int returnLotto(int money) {
        checkValidLottoMoneyAmount(money);
        return money / LOTTO_MONEY_AMOUNT;
    }

    private static void checkValidLottoMoneyAmount(int money) {
        if (money < LOTTO_MONEY_AMOUNT) {
            throw new MyException(MyErrorCode.LESS_THAN_LOTTO_MONEY_AMOUNT);
        }
    }

}
