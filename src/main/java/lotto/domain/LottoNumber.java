package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LottoNumber.LOTTO_START_NUMBER || lottoNumber > LottoNumber.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호 범위는 1 ~ 45 입니다.");
        }
    }

    public String getValue() {
        return Integer.toString(lottoNumber);
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
