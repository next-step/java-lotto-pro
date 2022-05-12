package lotto.domain;

import java.util.Arrays;

public class LottoTicket {
    private static final int AMOUNT_OF_NUMBERS = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final int[] numbers;

    public LottoTicket(final int[] numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private static void validateNumbers(final int[] numbers) {
        checkAmountOfNumbers(numbers);
        for (final int number : numbers) {
            checkRangeOfNumber(number);
        }
    }

    private static void checkAmountOfNumbers(final int[] numbers) {
        if (numbers.length != AMOUNT_OF_NUMBERS) {
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
                "numbers=" + Arrays.toString(numbers) +
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
        return Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }
}
