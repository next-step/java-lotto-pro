package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static final String DELIMITER_COMMA = ",";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static int getSum(String[] splits) {
        return Arrays.stream(splits)
                .mapToInt(Integer::parseInt)
                .sum();

    }

    private static String[] split(String input) {
        return input.split(DELIMITER_COMMA);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
