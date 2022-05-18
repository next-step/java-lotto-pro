package lotto.domain;

import static lotto.common.ErrorMessage.INVALID_MONEY_ERROR;
import static lotto.common.ErrorMessage.MINIMUM_MONEY_ERROR;
import static lotto.common.ErrorMessage.NULL_OR_EMPTY_ERROR;
import static lotto.common.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.Objects;

public class Money {
    private static final String NUMBER_FORMAT_REGEX = "^[0-9]*$";
    public static final int PRICE_PER_LOTTO = 1_000;

    private final int money;

    public Money(String money) {
        this.money = validateMoney(money);
    }

    private int validateMoney(String money) {
        validateNullOrEmpty(money);
        validateFormat(money);
        int parsedMoney = Integer.parseInt(money);
        validateMinimumSize(parsedMoney);
        validateSize(parsedMoney);
        return parsedMoney;
    }

    private static void validateNullOrEmpty(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR.getErrorMessage());
        }
    }

    private void validateFormat(String money) {
        if (!money.matches(NUMBER_FORMAT_REGEX)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    private void validateSize(int parsedMoney) {
        if (parsedMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_ERROR.getErrorMessage());
        }
    }

    private void validateMinimumSize(int parsedMoney) {
        if (parsedMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MINIMUM_MONEY_ERROR.getErrorMessage());
        }
    }

    public int calculateLottoCount() {
        return this.money / PRICE_PER_LOTTO;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
