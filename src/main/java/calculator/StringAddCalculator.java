package calculator;

import static java.util.Arrays.stream;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = StringParser.split(input);

        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static int sum(String[] numbers) {
        return stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
