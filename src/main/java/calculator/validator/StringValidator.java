package calculator.validator;

import static calculator.constants.ErrorMessage.INVALID_NUMBER_ERROR_MESSAGE;
import static calculator.constants.ErrorMessage.NEGATIVE_NUMBER_ERROR_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022/05/12 3:42 오후
 */
public class StringValidator {

    public static boolean isValidNumber(String input) {
        return isNumber(input) && isPositiveNumber(input);
    }

    public static boolean isEmpty(String given) {
        return given == null || isBlank(given);
    }

    private static boolean isBlank(String given) {
        return given.trim().length() == 0;
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

    private static void numberValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void positiveNumberValidation(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
