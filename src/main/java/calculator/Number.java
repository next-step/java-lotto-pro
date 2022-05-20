package calculator;

import java.util.regex.Pattern;

public class Number {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String ERROR_MSG_NOT_NUMBER = "0 이상의 정수만 입력 가능합니다.";
    private int number;

    public Number(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return this.number;
    }

    public void add(Number number) {
        this.number += number.getNumber();
    }

    public static void validate(String number) {
        if (!Pattern.matches(NUMBER_REGEX, number)) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_NUMBER);
        }
    }
}
