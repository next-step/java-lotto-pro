package calculator;

import calculator.utils.ValidationUtils;

public class Number {
    private int number;

    public Number(String number) {
        ValidationUtils.validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return this.number;
    }

    public void add(Number number) {
        this.number += number.getNumber();
    }
}
