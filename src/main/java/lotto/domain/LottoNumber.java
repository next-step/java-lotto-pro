package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        numberRangeValid(number);
        this.number = number;
    }

    private void numberRangeValid(int lottoNumber) {
        if (!(lottoNumber >= LottoNumber.LOTTO_START_NUMBER && lottoNumber <= LottoNumber.LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number + "";
    }
}
