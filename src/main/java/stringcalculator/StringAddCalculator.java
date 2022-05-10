package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(convertToIntegers(split(input)));
    }

    private static boolean isBlank(String input) {
        return isNull(input) || input.isEmpty();
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

    private static List<Integer> convertToIntegers(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(Integer.parseInt(value));
        }
        return numbers;
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isNull(String input) {
        return input == null;
    }
}
