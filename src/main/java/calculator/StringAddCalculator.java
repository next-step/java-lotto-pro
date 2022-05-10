package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] split = input.split(DEFAULT_DELIMITER);
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }
}
