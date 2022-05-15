package lotto.domain;

import lotto.constant.ErrorMessageConst;

public class Money {
    private int amount;

    public static final int LOTTO_PRICE = 1000;

    public Money(int amount){
        this.amount = validateMoney(amount);
    }

    private int validateMoney(int amount) {
        validateMoneyPositive(amount);
        validateMoneyExceedLottoPrice(amount);
        return amount;
    }

    private void validateMoneyPositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_NEGATIVE_INTEGER);
        }
    }

    private void validateMoneyExceedLottoPrice(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_INVALID_MONEY_MINIMUM_VALUE, LOTTO_PRICE)
            );
        }
    }

    public int getAmount() {
        return amount;
    }

    public int lottoCountToBuy() {
        return amount/ LOTTO_PRICE;
    }
}
