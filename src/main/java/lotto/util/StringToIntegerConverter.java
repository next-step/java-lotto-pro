package lotto.util;

import lotto.domain.message.ErrorMessage;

public class StringToIntegerConverter {
    public static int parseInt(final String input, final ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
