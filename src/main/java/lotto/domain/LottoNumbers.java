package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
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
