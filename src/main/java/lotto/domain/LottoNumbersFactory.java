package lotto.domain;

import static lotto.domain.LottoNumbersCondition.AMOUNT_OF_NUMBERS;
import static lotto.domain.LottoNumbersCondition.MAXIMUM_NUMBER;
import static lotto.domain.LottoNumbersCondition.MINIMUM_NUMBER;
import static lotto.domain.message.ErrorMessage.INVALID_LOTTO_NUMBERS;

import java.util.List;
import lotto.service.StringToNumbersConverter;

public class LottoNumbersFactory {
    public LottoNumbers create(final List<Integer> numbers) {
        validateNumbers(numbers);
        return new LottoNumbers(numbers);
    }

    public LottoNumbers convertAndCreate(final String numbersString) {
        try {
            return create(StringToNumbersConverter.convert(numbersString));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateNumbers(final List<Integer> numbers) {
        checkAmountOfNumbers(numbers);
        for (final int number : numbers) {
            checkRangeOfNumber(number);
        }
    }

    private void checkAmountOfNumbers(final List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    private void checkRangeOfNumber(final int number) {
        if (number < MINIMUM_NUMBER.getCondition() || number > MAXIMUM_NUMBER.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }
}
