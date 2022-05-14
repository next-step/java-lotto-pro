package calculator;

import java.util.regex.Pattern;

public class StringRegex {
    private static final Pattern NON_VALID_INPUT = Pattern.compile("[a-zA-Z가-힣]+");

    public static boolean isValid(String input) {
        return NON_VALID_INPUT.matcher(input)
                              .find();
    }
}
