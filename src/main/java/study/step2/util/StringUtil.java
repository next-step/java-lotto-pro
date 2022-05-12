package study.step2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String BASIC_DELIMITER_REGEX = "[:,]";

    private StringUtil() {
    }

    public static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASIC_DELIMITER_REGEX);
    }

    public static int parseNonNegativeNumber(String number) {
        int result = Integer.parseInt(number);
        validateNonNegative(result);
        return result;

    }

    private static void validateNonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
    }
}
