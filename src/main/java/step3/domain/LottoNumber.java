package step3.domain;

import java.util.Objects;

import step3.domain.constance.LottoConstant;

public class LottoNumber {

    private final int lotteNumber;

    public LottoNumber(int lotteNumber) {
        rangeNumberValid(lotteNumber);
        this.lotteNumber = lotteNumber;
    }

    public int toInt() {
        return lotteNumber;
    }

    private void rangeNumberValid(int lotteNumber) {
        if (lotteNumber < LottoConstant.RANGE_MIN_LOTTO_NUMBER || lotteNumber > LottoConstant.RANGE_MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoConstant.RANGE_OVER_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return lotteNumber == that.lotteNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteNumber);
    }
}
