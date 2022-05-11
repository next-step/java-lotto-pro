package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringUtils {
    private static final String DEFAULT_DELIMITER_TEXT = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String ERROR_MESSAGE_INVALID_NEGATIVE_NUMBER = "[Error] 음수는 입력할 수 없습니다.";
    private static final String ERROR_MESSAGE_INVALID_NUMBER_FORMAT = "[Error] 올바른 숫자가 아닙니다.";

    public static String[] splitString(String str) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return str.split(DEFAULT_DELIMITER_TEXT);
    }

    public static int parseStringToPositiveInteger(String str) {
        int parsedInt = parseStringToInteger(str);
        if (parsedInt < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NEGATIVE_NUMBER);
        }
        return parsedInt;
    }

    private static int parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER_FORMAT);
        }
    }
}
