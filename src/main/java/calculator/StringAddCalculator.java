package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String DELIMITER = "[,:]";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }
        return sum(changeNumbers(split(input)));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    private static int sum(int[] inputs) {
        return Arrays.stream(inputs).sum();
    }

    private static int[] changeNumbers(String[] inputs) {
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
    }

}