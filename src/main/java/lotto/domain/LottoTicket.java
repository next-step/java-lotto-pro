package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    public static final int AMOUNT_OF_NUMBERS = 6;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public LottoTicket(final List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private static void validateNumbers(final List<Integer> numbers) {
        checkAmountOfNumbers(numbers);
        for (final int number : numbers) {
            checkRangeOfNumber(number);
        }
    }

    private static void checkAmountOfNumbers(final List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkRangeOfNumber(final int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
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
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
