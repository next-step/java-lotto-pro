package lotto.domain;

import lotto.cons.ErrorMessageConst;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private int amount;

    public Money(int amount){
        this.amount = validateMoney(amount);
    }

    private int validateMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_NEGATIVE_INTEGER);
        }
        return amount;
    }

    public int getAmount() {
        return amount;
    }

    public int lottoCountToBuy() {
        return amount/ LOTTO_PRICE;
    }
}
