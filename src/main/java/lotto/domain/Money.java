package lotto.domain;

import lotto.view.OutputView;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private int amount;
    private int count;

    public Money(int amount) {
        this.amount = amount;
        this.count = isValidCount(amount);
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    private int isValidCount(int amount) {
        if (amount < 0) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
        if (amount % LOTTO_PRICE > 0) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
        return amount/LOTTO_PRICE;
    }

    public int getCount() {
        return this.count;
    }
}
