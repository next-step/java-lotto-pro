package stringAddCalculator.domain;

import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class Number {
    private int number;

    public Number(String input) throws IllegalAccessException {
        isDigitAndPositiveNum(input);
        this.number = Integer.parseInt(input);
    }

    public int getNumber() {
        return this.number;
    }

    public void isDigitAndPositiveNum(String input) throws IllegalAccessException {
        if (input.length() > 1) {
            throw new IllegalAccessException(INPUT_ERROR);
        }

        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalAccessException(INPUT_ERROR);
        }
    }
}
