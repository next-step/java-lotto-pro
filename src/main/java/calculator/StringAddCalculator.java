package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        String[] numbers = split(text);

        return sum(numbers);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(SEPARATOR);
    }

    private static int sum(String[] numbers) {
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            result += convertToInteger(numbers[i]);
        }

        return result;
    }

    private static int convertToInteger(String value) {
        try {
            int result = Integer.parseInt(value);
            validatePositive(result);
            return result;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static void validatePositive(int value) {
        if (0 > value) {
            throw new RuntimeException("양수가 아닙니다.");
        }
    }

}
