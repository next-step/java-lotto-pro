package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static final int DEFAULT = 0;
    public static final String DELIMITER = ",";

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return DEFAULT;
        }

        return sum(parse(split(input)));
    }

    private static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        return false;
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    private static List<Integer> parse(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(DEFAULT, (a, b) -> a + b);
    }
}
