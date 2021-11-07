package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LottoNumberRange.LOTTO_NUMBER_MIN_RANGE.getRange()
            || number > LottoNumberRange.LOTTO_NUMBER_MAX_RANGE.getRange()) {
            throw new IllegalArgumentException(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
