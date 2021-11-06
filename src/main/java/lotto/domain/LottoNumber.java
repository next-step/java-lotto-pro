package lotto.domain;

import lotto.exception.IllegalLottoNumberException;

public class LottoNumber {
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalLottoNumberException();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
