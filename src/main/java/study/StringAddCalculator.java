package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String[] DEFAULT_DELIMITER = {",", ":"};
    private static final int DEFAULT_FAILURE_VALUE = 0;
    private static final int REGEX_FIRST_GROUP_INDEX = 1;
    private static final Pattern PATTERN_FIND_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.+)");
    private static final Pattern PATTERN_FIND_BODY_TEXT = Pattern.compile("(?://.\n)?(.+)");

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_FAILURE_VALUE;
        }

        String customDelimiter = getCustomDelimiter(text);
        String[] numberStrings = splitWithCustomDelimiter(text, customDelimiter);
        return getSumPositiveValue(numberStrings);
    }

    private static String[] splitWithCustomDelimiter(String text, String customDelimiter) {
        String regex = String.join("|", DEFAULT_DELIMITER);
        if (!isEmpty(customDelimiter)) {
            regex += "|" + customDelimiter;
        }
        return getBodyText(text).split(regex);
    }

    private static String getCustomDelimiter(String text) {
        return findFirstMatchedGroup(text, PATTERN_FIND_CUSTOM_DELIMITER);
    }

    private static String getBodyText(String text) {
        return findFirstMatchedGroup(text, PATTERN_FIND_BODY_TEXT);
    }

    private static String findFirstMatchedGroup(String text, Pattern pattern) {
        String result = "";
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            result = m.group(REGEX_FIRST_GROUP_INDEX);
        }
        return result;
    }

    private static int getSumPositiveValue(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += parsePositiveInt(number);
        }
        return result;
    }

    private static int parsePositiveInt(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new RuntimeException("양의 정수 값을 입력해 주세요");
        }
        return value;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
