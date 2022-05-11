package calculator;

public class StringAddCalculator {
    private static final int MIN_VALUE = 0;
    private static final int SINGLE_DIGIT = 1;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return MIN_VALUE;
        }

        return splitValue(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int splitValue(String input) {
        if (isSingleDigit(input)) {
            return Integer.parseInt(input);
        }

        return Integer.parseInt(input);
    }

    private static boolean isSingleDigit(String input) {
        return input.length() == SINGLE_DIGIT;
    }
}
