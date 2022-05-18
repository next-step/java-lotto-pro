package lotto.domain.validator.impl;

import lotto.domain.validator.NumberValidator;
import lotto.exception.ExceptionType;

public class NumberFormatValidator implements NumberValidator {

    @Override
    public void validate(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
