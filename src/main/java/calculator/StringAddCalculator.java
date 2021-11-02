package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_PATTERN_SEPARATOR = "//(.)\n(.*)";

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
            ;
        }
        return sum;
    }

    private static int mapToInt(String text) {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자형식이 아닙니다.");
        }
        return number;
    }

    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitString(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN_SEPARATOR).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(SEPARATOR);
    }
}
