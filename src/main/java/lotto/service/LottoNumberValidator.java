package lotto.service;

import static lotto.domain.LottoCondition.MAXIMUM_NUMBER;
import static lotto.domain.LottoCondition.MINIMUM_NUMBER;
import static lotto.domain.message.ErrorMessage.INVALID_LOTTO_NUMBERS;

public class LottoNumberValidator {
    public static void checkRangeOfNumber(final int number) {
        if (number < MINIMUM_NUMBER.getCondition() || number > MAXIMUM_NUMBER.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }
}
