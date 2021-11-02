package calculator;

import static java.util.Arrays.stream;

public class StringAddCalculator {

    private static final String STRING_DELIMITER = "[,:]";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return calculateStringAdd(input);
    }

    private static int calculateStringAdd(String input) {
        String[] numbers = input.split(STRING_DELIMITER);
        return stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
