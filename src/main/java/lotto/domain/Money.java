package lotto.domain;

import static lotto.common.Messages.MONEY_NOT_NUMBER;
import static lotto.common.Messages.POSITIVE_MONEY;

public class Money {
    private static final int MINIMUM_AMOUNT = 0;

    private final int money;

    public Money(String money) {
        validateNumber(money);
        int validatedNumber = Integer.parseInt(money);

        validateMinimumMoney(validatedNumber);
        this.money = validatedNumber;
    }

    private void validateNumber(String money) {
        if (!isNumber(money)) {
            throw new IllegalArgumentException(MONEY_NOT_NUMBER);
        }
    }

    private void validateMinimumMoney(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(POSITIVE_MONEY);
        }
    }

    private boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int currentMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}
