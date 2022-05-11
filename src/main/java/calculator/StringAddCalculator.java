package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int MIN_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 입력할 수 없습니다.";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return MIN_VALUE;
        }

        String[] inputs = splitValue(input);
        return calculateSum(inputs);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitValue(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static int calculateSum(String[] inputs) {
        int[] numbers = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            negativeNumberCheck(number);
        }
        return Arrays.stream(numbers).sum();
    }

    private static void negativeNumberCheck(int number) {
        if (number < MIN_VALUE) {
            throw new RuntimeException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
