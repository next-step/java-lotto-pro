package lotto.util;

import lotto.constants.ErrorMessage;

public class StringToIntegerParser {
    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORMAT);
        }
    }
}
