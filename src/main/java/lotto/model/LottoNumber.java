package lotto.model;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validLottoRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validLottoRange(int lottoNumber) {
        if (isNotLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException("로또 숫자 범위가 아닙니다.");
        }
    }

    private boolean isNotLottoNumberRange(int lottoNumber) {
        return lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER;
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
}
