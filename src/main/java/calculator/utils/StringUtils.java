package calculator.utils;

import static calculator.validator.StringValidator.numberValidation;
import static calculator.validator.StringValidator.positiveNumberValidation;

/**
 * @author : choi-ys
 * @date : 2022/05/13 10:52 오전
 */
public class StringUtils {

    public static final int ZERO = 0;

    public static boolean isValidNumber(String input) {
        return isNumber(input) && isPositiveNumber(input);
    }

    public static boolean isEmpty(String input) {
        return input == null || isBlank(input);
    }

    private static boolean isBlank(String input) {
        return input.trim().length() == 0;
    }

    private static boolean isNumber(String input) {
        try {
            numberValidation(input);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getLocalizedMessage());
            return false;
        }
        return true;
    }

    private static boolean isPositiveNumber(String input) {
        try {
            positiveNumberValidation(input);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getLocalizedMessage());
            return false;
        }
        return true;
    }

    public static int processNotExistDelimiterAndEmptyString(String input) {
        return ZERO;
    }

    public static int processNotExistDelimiterString(String input) {
        return Integer.parseInt(input);
    }
}
