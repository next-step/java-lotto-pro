package lotto.domain;

import java.util.Objects;
import lotto.exception.LottoNumberRangeException;

public class LottoNumber {

    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_LOWER_BOUND || lottoNumber > LOTTO_NUMBER_UPPER_BOUND) {
            throw new LottoNumberRangeException();
        }
    }

    public int value() {
        return lottoNumber;
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}

