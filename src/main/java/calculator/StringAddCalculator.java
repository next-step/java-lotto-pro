package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_PATTERN_SEPARATOR = "//(.)\n(.*)";
    private static final int NEGATIVE_CANNOT_INT = 0;
    private static final int CUSTOM_PATTERN_DELIMITER = 1;
    private static final int CUSTOM_SPLIT_BY_DELIMITER = 2;

    public static int splitAndSum(String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        String[] numbers = splitString(text);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += mapToInt(numbers[i]);
        }
        return sum;
    }

    private static int mapToInt(String text) {
        int number;
        try {
            number = Integer.parseInt(text);
            checkIfPositive(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자형식이 아닙니다.");
        }
        return number;
    }

    private static void checkIfPositive(int number) {
        if (number < NEGATIVE_CANNOT_INT) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }

    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitString(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN_SEPARATOR).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_PATTERN_DELIMITER);
            return matcher.group(CUSTOM_SPLIT_BY_DELIMITER).split(customDelimiter);
        }
        return text.split(SEPARATOR);
    }
}
