package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String BASIC_DELIMITER_REGEX = "[:,]";
    private static final int DEFAULT_RETURN_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return DEFAULT_RETURN_VALUE;
        }
        return addAllNumberStrings(splitText(text));
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASIC_DELIMITER_REGEX);
    }

    private static int addAllNumberStrings(String[] numberStrings) {
        int result = 0;
        int tempNumber;
        for (String numberString : numberStrings) {
            tempNumber = parseNumber(numberString);
            validateNonNegative(tempNumber);
            result = result + tempNumber;
        }
        return result;
    }

    private static int parseNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("숫자만 더할 수 있습니다.");
        }
    }

    private static void validateNonNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("0보다 큰 수를 입력해주세요.");
        }
    }
}
