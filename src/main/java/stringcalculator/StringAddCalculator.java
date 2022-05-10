package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS_REGEX = "[,:]";
    public static final String INTEGER_TYPE_REGEX = "-?\\d+";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int NUMBERS_GROUP = 2;

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
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(NUMBERS_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS_REGEX);
    }

    private static List<Integer> convertToIntegers(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(checkPositiveNumber(value));
        }
        return numbers;
    }

    private static int checkPositiveNumber(String value) {
        int number = checkInteger(value);
        if (isNegativeNumber(number)) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private static int checkInteger(String value) {
        if (isNotInteger(value)) {
            throw new IllegalArgumentException("정수 타입을 입력 하세요");
        }
        return Integer.parseInt(value);
    }

    private static boolean isNotInteger(String value) {
        return !value.matches(INTEGER_TYPE_REGEX);
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
