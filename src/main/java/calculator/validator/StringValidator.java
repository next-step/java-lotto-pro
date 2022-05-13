package calculator.validator;

import static calculator.constants.ErrorMessage.INVALID_NUMBER_ERROR_MESSAGE;
import static calculator.constants.ErrorMessage.NEGATIVE_NUMBER_ERROR_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022/05/12 3:42 오후
 */
public class StringValidator {

    public static void numberValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void positiveNumberValidation(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
