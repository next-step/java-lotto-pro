package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import lotto.constant.ErrorCode;

public class Money {

    private final int money;

    public Money(int money) {
        validateMinPrice(money);
        this.money = money;
    }

    private void validateMinPrice(int money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorCode.로또를_구매하기_위해서는_1000원_이상_필요.getErrorMessage());
        }
    }

    public int maxLottoCount() {
        return money / LOTTO_PRICE;
    }
}
