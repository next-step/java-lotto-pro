package lotto.domain;

import java.util.Arrays;

public class LottoTicket {
    private final int[] numbers;

    public LottoTicket(final int[] numbers) {
        this.numbers = numbers;
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
