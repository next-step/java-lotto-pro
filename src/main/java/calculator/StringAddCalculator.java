package calculator;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        List<Integer> numbers = StringAddParser.split(input);

        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }

}
