package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_UPPER_BOUND;

import java.util.Objects;
import lotto.dto.LottoNumberDTO;
import lotto.exception.LottoNumberRangeException;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public LottoNumberDTO toLottoNumberDTO() {
        return new LottoNumberDTO(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_LOWER_BOUND || lottoNumber > LOTTO_NUMBER_UPPER_BOUND) {
            throw new LottoNumberRangeException();
        }
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

