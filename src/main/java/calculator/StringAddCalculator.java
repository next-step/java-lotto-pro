package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final int MIN_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";

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
        return input.split(DEFAULT_DELIMITER);
    }

    private static int calculateSum(String[] inputs) {
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).sum();
    }
}
