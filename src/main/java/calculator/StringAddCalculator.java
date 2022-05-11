package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final int MIN_VALUE = 0;
    private static final int SINGLE_DIGIT = 1;
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_AND_COLON_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return MIN_VALUE;
        }

        String[] inputs = splitValue(input);
        return calculateSum(inputs);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitValue(String input) {
        if (isSingleDigit(input) || isCommaInput(input)) {
            return input.split(COMMA_DELIMITER);
        }
        return input.split(COMMA_AND_COLON_DELIMITER);
    }

    private static boolean isSingleDigit(String input) {
        return input.length() == SINGLE_DIGIT;
    }

    private static boolean isCommaInput(String input) {
        return input.matches(COMMA_DELIMITER);
    }

    private static int calculateSum(String[] inputs) {
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).sum();
    }
}
