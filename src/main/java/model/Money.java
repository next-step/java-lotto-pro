package model;

import static common.Constants.LOTTO_PRICE;

public class Money {

    private final int money;

    public Money(int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요.");
        }

        this.money = inputMoney;
    }

    public int availableBuyLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}
