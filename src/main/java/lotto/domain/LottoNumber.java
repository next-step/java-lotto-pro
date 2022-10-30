package lotto.domain;

import static lotto.ui.ConsoleMessage.ERROR_VALID_LOTTO_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final int value;

    public LottoNumber(final int number) {
        validate(number);
        this.value = number;
    }

    private void validate(final int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(ERROR_VALID_LOTTO_NUMBER.getMessage(), number));
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(final LottoNumber lottoNumber) {
        return Integer.compare(this.getValue(), lottoNumber.getValue());
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.value;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
