package lotto.domain;

import java.util.List;
import java.util.Objects;
import lotto.service.LottoNumbersValidator;
import lotto.service.StringToNumbersConverter;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(final List<Integer> numbers) {
        LottoNumbersValidator.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers convertAndCreate(final String numbersString) {
        return new LottoNumbers(StringToNumbersConverter.convert(numbersString));
    }

    public int matches(final LottoNumbers winningNumbers) {
        int matches = 0;
        for (final int number : winningNumbers.numbers) {
            matches += numbers.contains(number) ? 1 : 0;
        }
        return matches < 3 ? 0 : matches;
    }

    public boolean matchesBonusBall(final BonusBall bonusBall) {
        return numbers.contains(bonusBall.getNumber());
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
