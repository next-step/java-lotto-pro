package lotto.domain;

import static lotto.constants.Message.INPUT_AMOUNT_ERROR;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private int amount;
    private int count;

    public Money(int amount) {
        validAmount(amount);
        validCount(amount);
        this.amount = amount;
        this.count = amount/LOTTO_PRICE;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    private void validAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(INPUT_AMOUNT_ERROR);
        }
    }

    private void validCount(int amount) {
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(INPUT_AMOUNT_ERROR);
        }
    }

    public int getCount() {
        return this.count;
    }
}
