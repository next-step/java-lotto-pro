package lotto.domain;

import lotto.constant.ErrorMessageConst;

public class Money {
    private final int amount;

    public static final int LOTTO_PRICE = 1000;

    public Money(int amount){
        validateMoney(amount);
        this.amount = amount;
    }

    private void validateMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_NEGATIVE_INTEGER);
        }
    }

    public LottoCount maxLottoCount() {
        return new LottoCount(amount / LOTTO_PRICE);
    }

    public double calculateProfit(int changedAmount) {
        return (double) changedAmount / (maxLottoCount().getCount() * LOTTO_PRICE);
    }

    public Money subtract(int subtractAmount) {
        return new Money(amount - subtractAmount);
    }

    public int getAmount() {
        return amount;
    }
}
