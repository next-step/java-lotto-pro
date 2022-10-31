package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.Objects;

public class LottoNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private final int lottoNumber;

    public LottoNumber(int number) {
        this.validateRange(number);
        this.lottoNumber = number;
    }

    private void validateRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
        }
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
