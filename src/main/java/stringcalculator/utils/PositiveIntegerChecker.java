package stringcalculator.utils;

import static stringcalculator.constants.ErrorMessageConstants.NON_POSITIVE_INTEGER_INPUT_ERROR;

public class PositiveIntegerChecker {

    private static final String POSITIVE_INTEGER_TYPE_REGEX = "\\d+";

    public static boolean isPositiveInteger(String input) {
        if (isNotPositiveInteger(input)) {
            throw new IllegalArgumentException(NON_POSITIVE_INTEGER_INPUT_ERROR);
        }
        return true;
    }

    private static boolean isNotPositiveInteger(String input) {
        return !input.matches(POSITIVE_INTEGER_TYPE_REGEX);
    }
}
