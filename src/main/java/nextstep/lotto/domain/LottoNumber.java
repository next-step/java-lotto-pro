package nextstep.lotto.domain;

import nextstep.lotto.constance.LottoExceptionMessage;
import nextstep.lotto.exception.LottoRuntimeException;

public class LottoNumber {

    private static final LottoNumber LOTTO_MIN_NUMBER = new LottoNumber(1);
    private static final LottoNumber LOTTO_MAX_NUMBER = new LottoNumber(9);

    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(Integer lottoNumber) {
        if (!(LOTTO_MIN_NUMBER.isGreaterThanEqual(lottoNumber) && LOTTO_MAX_NUMBER.isLessThanEqual(lottoNumber))) {
            throw new LottoRuntimeException(LottoExceptionMessage.INVALID_LOTTO_NUMBER_MESSAGE);
        }
    }

    private Boolean isGreaterThanEqual(Integer lottoNumber) {
        return this.lottoNumber >= lottoNumber;
    }

    private Boolean isLessThanEqual(Integer lottoNumber) {
        return this.lottoNumber <= lottoNumber;
    }
}
