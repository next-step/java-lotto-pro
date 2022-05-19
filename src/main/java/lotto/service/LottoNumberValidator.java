package lotto.service;

import static lotto.domain.LottoCondition.MAXIMUM_NUMBER;
import static lotto.domain.LottoCondition.MINIMUM_NUMBER;

import lotto.domain.message.ErrorMessage;

public class LottoNumberValidator {
    public static void checkRangeOfNumber(final int number, final ErrorMessage errorMessage) {
        if (number < MINIMUM_NUMBER.getCondition() || number > MAXIMUM_NUMBER.getCondition()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
