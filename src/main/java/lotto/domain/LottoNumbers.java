package lotto.domain;

import static lotto.domain.LottoNumbersCondition.AMOUNT_OF_NUMBERS;
import static lotto.domain.LottoNumbersCondition.MAXIMUM_NUMBER;
import static lotto.domain.LottoNumbersCondition.MINIMUM_NUMBER;
import static lotto.domain.message.ErrorMessage.INVALID_LOTTO_NUMBERS;

import java.util.List;
import java.util.Objects;
import lotto.service.LottoNumbersStringConverter;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(final List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public LottoNumbers(final String numbersString) {
        this(LottoNumbersStringConverter.convert(numbersString));
    }

    private static void validateNumbers(final List<Integer> numbers) {
        checkAmountOfNumbers(numbers);
        for (final int number : numbers) {
            checkRangeOfNumber(number);
        }
    }

    private static void checkAmountOfNumbers(final List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void checkRangeOfNumber(final int number) {
        if (number < MINIMUM_NUMBER.getCondition() || number > MAXIMUM_NUMBER.getCondition()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    public int matches(final LottoNumbers winningNumbers) {
        int matches = 0;
        for (final int number : winningNumbers.numbers) {
            matches += numbers.contains(number) ? 1 : 0;
        }
        return matches < 3 ? 0 : matches;
    }

    public void print() {
        System.out.println(numbers);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
