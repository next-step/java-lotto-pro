package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final String ERROR_MESSAGE_NUMBER_OUT_OF_RANGE = "[ERROR] This number is out of range.";

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        validateNumberRange(number);

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_OUT_OF_RANGE);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof LottoNumber)) {
            return false;
        }
        return this.number == ((LottoNumber) obj).getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }
}
