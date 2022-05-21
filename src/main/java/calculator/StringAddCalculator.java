package calculator;

import static calculator.utils.CalculatorUtils.split;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input))
            return DEFAULT_VALUE;

        Numbers numbers = new Numbers(split(input));
        return numbers.sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
