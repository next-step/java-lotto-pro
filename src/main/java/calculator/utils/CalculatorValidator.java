package calculator.utils;

import java.util.regex.Pattern;

public class CalculatorValidator {

    public static final String ONLY_NUMBER_REGEX = "^\\d*$";

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isNull(String input) {
        return input==null;
    }

    public static void validateOnlyNumber(String input) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
