package lotto.domain;

import lotto.constant.Message;
import lotto.exception.LottoNumberRangeException;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER_FORTY_FIVE = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER_FORTY_FIVE) {
            throw new LottoNumberRangeException();
        }
    }

    public static LottoNumber from(final int lottoNumber) {
        validateLottoNumber(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    public int extractLottoNumber(){
        return lottoNumber;
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

