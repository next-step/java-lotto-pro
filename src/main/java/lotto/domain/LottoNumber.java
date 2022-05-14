package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER);
        }
        this.lottoNumber = number;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
