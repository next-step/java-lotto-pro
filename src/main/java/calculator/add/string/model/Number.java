package calculator.add.string.model;

import static calculator.add.string.constant.RegexConst.POSITIVE_INTEGER_TYPE_REGEX;

public class Number {

    private final int number;

    public Number(String number) {
        validateIsPositiveInteger(number);
        this.number = Integer.parseInt(number);
    }

    private void validateIsPositiveInteger(String input) {
        if (!input.matches(POSITIVE_INTEGER_TYPE_REGEX)) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
