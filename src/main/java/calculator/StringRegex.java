package calculator;

import java.util.regex.Pattern;

public class StringRegex {
    private static final Pattern INVALID_STRING_PATTERN = Pattern.compile("[a-zA-Z가-힣]+");

    public static boolean isInvalid(String input) {
        return INVALID_STRING_PATTERN.matcher(input)
                                     .find();
    }
}
