package lotto.domain;

import static lotto.domain.ExceptionMessage.NOT_UNSIGNED_INT;
import static lotto.domain.ExceptionMessage.OUT_OF_BOUNDS;

public class NumberOfGames {

    private final int value;

    public NumberOfGames(String number, int limit) {
        validateUnsignedInt(number);
        int value = Integer.parseUnsignedInt(number);
        validateBounds(value, limit);
        this.value = value;
    }

    private void validateUnsignedInt(String number) {
        try {
            Integer.parseUnsignedInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_UNSIGNED_INT.getMessage());
        }
    }

    private void validateBounds(int value, int limit) {
        if (value > limit) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
