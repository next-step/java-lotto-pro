package calculator.utils;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String ERROR_MSG_NOT_NUMBER = "0 이상의 정수만 입력 가능합니다.";

    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static void validateNumber(String number) {
        if (!Pattern.matches(NUMBER_REGEX, number)) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_NUMBER);
        }
    }
}
