package lotto.domain.validator.impl;

import lotto.domain.validator.NumberValidator;
import lotto.exception.ExceptionType;

public class OverlapBonusNumberValidator implements NumberValidator {

    @Override
    public void validate(String number, int... args) {
        for (int num : args) {
            equalsAndThrowsNumber(Integer.parseInt(number), num);
        }
    }

    private void equalsAndThrowsNumber(int source, int target) {
        if (source == target) {
            throw new IllegalArgumentException(
                ExceptionType.ALREADY_EXISTS_WINNINGS_NUMBER.getMessage());
        }
    }
}
