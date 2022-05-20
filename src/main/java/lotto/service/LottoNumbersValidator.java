package lotto.service;

import static lotto.domain.LottoCondition.AMOUNT_OF_NUMBERS;
import static lotto.domain.message.ErrorMessage.INVALID_LOTTO_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {
    public static void validateNumbers(final List<Integer> numbers) {
        checkAmountOfNumbers(numbers);
        for (final int number : numbers) {
            LottoNumberValidator.checkRangeOfNumber(number, INVALID_LOTTO_NUMBERS);
        }
        checkDuplication(numbers);
    }

    private static void checkAmountOfNumbers(final List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void checkDuplication(final List<Integer> numbers) {
        final Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }
}
