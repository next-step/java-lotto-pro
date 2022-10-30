package calculator;

import java.util.regex.Pattern;

public class Number {

    private static final Pattern IS_ONLY_NUMBER = Pattern.compile("^[0-9]*?");

    public Number(final String number) {
        if (!isNumber(number)) {
            throw new NumberFormatException("숫자만 입력가능합니다.");
        }
    }

    public boolean isNumber(final String number) {
        return IS_ONLY_NUMBER.matcher(number).matches();
    }
}
