package lotto.domain;

import static lotto.domain.ExceptionMessage.NOT_UNSIGNED_INT;

public class NumberOfGames {

    private final int value;

    public NumberOfGames(String number) {
        validateUnsignedInt(number);
        this.value = Integer.parseUnsignedInt(number);
    }

    private void validateUnsignedInt(String number) {
        try {
            Integer.parseUnsignedInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_UNSIGNED_INT.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
