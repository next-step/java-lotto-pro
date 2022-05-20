package lotto.domain;

import static lotto.domain.ExceptionMessage.NOT_UNSIGNED_INT;
import static lotto.domain.ExceptionMessage.ZERO;

public class Money {

    private final int value;

    public Money(String money) {
        validateUnsignedInt(money);
        int value = Integer.parseUnsignedInt(money);
        validateNotZero(value);
        this.value = value;
    }

    private void validateUnsignedInt(String money) {
        try {
            Integer.parseUnsignedInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_UNSIGNED_INT.getMessage());
        }
    }

    private void validateNotZero(int value) {
        if (value == 0) {
            throw new IllegalArgumentException(ZERO.getMessage());
        }
    }

    public int numberOfGames(int gamePrice) {
        return value / gamePrice;
    }
}
