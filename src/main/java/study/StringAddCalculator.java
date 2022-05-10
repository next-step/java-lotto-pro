package study;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";

    static int splitAndSum(String input) {

        if (isNullOrEmptyInput(input)) {
            return 0;
        }
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }

        return sumNumbers(splitToNumberArray(input));
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\p{Digit}");
    }

    private static List<Integer> splitToNumberArray(String input) {
        String[] numericStrings = input.split(DELIMITER);

        List<Integer> numbers = new ArrayList<>();
        for (String numericString : numericStrings) {
            numbers.add(Integer.parseInt(numericString));
        }
        return numbers;
    }

    private static int sumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

}
