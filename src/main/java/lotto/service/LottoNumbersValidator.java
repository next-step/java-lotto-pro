package lotto.service;

import static lotto.domain.LottoNumbersCondition.AMOUNT_OF_NUMBERS;
import static lotto.domain.message.ErrorMessage.INVALID_LOTTO_NUMBERS;

import java.util.List;

public class LottoNumbersValidator {
    public static void validateNumbers(final List<Integer> numbers) {
        checkAmountOfNumbers(numbers);
        for (final int number : numbers) {
            LottoNumberValidator.checkRangeOfNumber(number);
        }
    }

    private static void checkAmountOfNumbers(final List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }
}
