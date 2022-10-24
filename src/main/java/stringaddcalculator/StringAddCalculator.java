package stringaddcalculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        String[] strings = split(input);
        return sum(strings);
    }

    private static int sum(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
