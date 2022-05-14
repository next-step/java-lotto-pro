package step2.calculator.validator;

import static step2.calculator.constants.ErrorMessage.NEGATIVE_NUMBER_INPUT_ERROR;
import static step2.calculator.constants.ErrorMessage.NON_NUMERIC_INPUT_ERROR;

/**
 * @author : choi-ys
 * @date : 2022/05/14 9:53 오후
 */
public class StringValidator {

    public static void numericValidation(String given) {
        try {
            Integer.parseInt(given);
        } catch (NumberFormatException exception) {
            throw new RuntimeException(NON_NUMERIC_INPUT_ERROR);
        }
    }

    public static void positiveNumberValidation(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_INPUT_ERROR);
        }
    }
}
