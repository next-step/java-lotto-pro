package study;

import static study.StringAddCalculator.INVALID_INPUT_ERR_MSG;

public class Number {

    private final int number;

    public Number(String s) {
        this.number = Integer.parseInt(s);
        validateNegativeNumber();
    }

    private void validateNegativeNumber() {
        if(this.number < 0) {
            throw new RuntimeException(INVALID_INPUT_ERR_MSG);
        }
    }

    public int getNumber() {
        return this.number;
    }
}