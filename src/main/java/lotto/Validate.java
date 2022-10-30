package lotto;

import static lotto.Constant.REGEX_ONLY_NUMBER;

import java.util.regex.Pattern;

public class Validate {
    static int validatePay(String input) {
        if (!Pattern.matches(REGEX_ONLY_NUMBER, input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
