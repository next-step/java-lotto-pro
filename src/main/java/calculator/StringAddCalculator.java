package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public static final String DEFAULT_SEPARATOR_REGEX = ",";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] splitInputs = split(input);
        List<Integer> numbers = parsingNumber(splitInputs);

        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_SEPARATOR_REGEX);
    }

    private static List<Integer> parsingNumber(String[] splitInputs) {
        List<Integer> numbers = new ArrayList<>();

        for (String input : splitInputs) {
            numbers.add(Integer.parseInt(input));
        }

        return numbers;
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

}
