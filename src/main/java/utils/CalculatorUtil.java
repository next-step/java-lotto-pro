package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_DELIMITER_GROUP_NUM = 2;
    private static final int POSITIVE_NUM = 0;
    private static final String ERROR_MESSAGE_INVALID_INPUT_NOT_NUMBER = "[Error] 입력 값이 숫자가 아닙니다.";
    private static final String ERROR_MESSAGE_INVALID_INPIT_NOT_POSITIVE = "[Error] 입력 값이 양수가 아닙니다.";

    public static String[] splitInput(String input) {
        Matcher m = CUSTOM_DELIMITER.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(CUSTOM_DELIMITER_GROUP_NUM).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    public static int checkPositiveNum(String str) {
        int num = checkNum(str);
        if (num < POSITIVE_NUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_INPIT_NOT_POSITIVE);
        }
        return num;
    }

    private static int checkNum(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_INPUT_NOT_NUMBER);
        }
    }
}
