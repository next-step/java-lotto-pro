package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final String ERROR_MSG_NUMBER_RANGE = "로또 번호가 범위에서 벗어났습니다.";

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void validateRange(int lottoNumber) {
        if (lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MSG_NUMBER_RANGE);
        }
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.getLottoNumber();
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
        return String.valueOf(lottoNumber);
    }
}
