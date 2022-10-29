package step3.domain;

import java.util.Objects;
import step3.message.ErrorMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private final int number;

    public LottoNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private static void validateNumberRange(final int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.ERR_LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
