package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        String[] tokens = Splitter.split(input);
        int[] numbers = Converter.convert(tokens);
        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
