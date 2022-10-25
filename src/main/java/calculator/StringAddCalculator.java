package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int MATCHER_GROUP_INDEX_FOR_DELIMITER = 1;
    private static final int MATCHER_GROUP_INDEX_FOR_TARGET_STRING = 2;
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";
    public static final String INVALID_NUMBER_MESSAGE = "유효하지 않은 값이 입력되었습니다.";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        String[] numbers = splitText(text);
        return sumNumbers(numbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitText(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(MATCHER_GROUP_INDEX_FOR_DELIMITER);
            return m.group(MATCHER_GROUP_INDEX_FOR_TARGET_STRING).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int sumNumbers(String[] numbers) {
        validateNumbers(numbers);
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static void validateNumbers(String[] numbers) {
        boolean isPositiveNumber = Arrays.stream(numbers).allMatch(number -> number.matches(POSITIVE_NUMBER_REGEX));
        if (!isPositiveNumber) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }
}
