package calculator;

import lotto.util.StringUtils;

public class StringAddCalculator {
    public static final int NUMBER_ZERO = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return NUMBER_ZERO;
        }
        return PositiveNumbers.from(StringUtils.split(input))
                .getSum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
