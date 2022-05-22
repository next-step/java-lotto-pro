package lotto.domain;

import static lotto.domain.ExceptionMessage.NOT_ENOUGH_AMOUNT;
import static lotto.domain.ExceptionMessage.NOT_UNSIGNED_INT;

public class Money {

    private final int value;

    public Money(String money, int pricePerGame) {
        validateUnsignedInt(money);
        int value = Integer.parseUnsignedInt(money);
        validateEnoughAmount(value, pricePerGame);
        this.value = value;
    }

    private void validateUnsignedInt(String money) {
        try {
            Integer.parseUnsignedInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_UNSIGNED_INT.getMessage());
        }
    }

    private void validateEnoughAmount(int value, int pricePerGame) {
        if (value / pricePerGame < 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_AMOUNT.getMessage());
        }
    }

    public int numberOfGames(int gamePrice) {
        return value / gamePrice;
    }
}
