package step3.domain;

import java.util.Objects;
import step3.Utils;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_RANGE_EXCEPTION = "로또번호는 1부터 45까지의 숫자여야 합니다.";
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        int number = Utils.parseInt(lottoNumber);
        this.lottoNumber = validLottoNumber(number);
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = validLottoNumber(lottoNumber);
    }

    private static int validLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION);
        }
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
