package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringUtils {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String DEFAULT_DELIMITER_TEXT = ",|:";
    public static final String ERROR_MESSAGE_INVALID_NEGATIVE_NUMBER = "[Error] 음수는 입력할 수 없습니다.";
    public static final String ERROR_MESSAGE_INVALID_NUMBER_FORMAT = "[Error] 올바른 숫자가 아닙니다.";

    public static String[] splitString(String str) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return str.split(DEFAULT_DELIMITER_TEXT);
    }

    public static int parseStringToPositiveInteger(String str) {
        int i = parseStringToInteger(str);
        if (i < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NEGATIVE_NUMBER);
        }
        return i;
    }

    private static int parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER_FORMAT);
        }
    }
}
