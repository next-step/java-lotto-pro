package calculator;

import exception.ExceptionMessage;

import static calculator.StringAddCalculator.ZERO;

public class Number {

    private final int number;

    public Number(String number) {
        try {
            this.number = Integer.parseInt(number);
            validatePositiveNumber();
        } catch (NumberFormatException | IllegalStateException e) {
            throw new RuntimeException(ExceptionMessage.NOT_POSITIVE_NUMBER.message());
        }
    }

    public int value() {
        return number;
    }

    private void validatePositiveNumber() {
        if (number < ZERO) {
            throw new IllegalStateException();
        }
    }
}
