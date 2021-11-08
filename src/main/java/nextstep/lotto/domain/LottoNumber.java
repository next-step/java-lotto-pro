package nextstep.lotto.domain;

import nextstep.lotto.constance.LottoExceptionMessage;
import nextstep.lotto.exception.LottoRuntimeException;

import java.util.Objects;

public class LottoNumber {

    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 9;

    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(Integer lottoNumber) {
        if (!(LOTTO_MIN_NUMBER <= lottoNumber && LOTTO_MAX_NUMBER >= lottoNumber)) {
            throw new LottoRuntimeException(LottoExceptionMessage.INVALID_LOTTO_NUMBER_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
