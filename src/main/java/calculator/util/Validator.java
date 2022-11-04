package calculator.util;

import calculator.constant.Regex;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static void isPositiveNumber(String number) {
        if (!isOnlyNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOnlyNumber(String number) {
        return Pattern.matches(Regex.ONLY_NUMBER.getRegex(), number);
    }
}
