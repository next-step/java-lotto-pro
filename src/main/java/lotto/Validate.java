package lotto;

import java.util.regex.Pattern;

public class Validate {
    private static final String REGEX_ONLY_NUMBER = "^[0-9]*$";

    static int validatePay(String input) {
        if (!Pattern.matches(REGEX_ONLY_NUMBER, input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
