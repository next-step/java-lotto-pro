package lotto.domain;

import lotto.domain.error.LottoNumberErrorCode;
import lotto.infrastructure.util.StringUtils;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(final String lottoNumber) {
        validateNullOrEmpty(lottoNumber);

        this.lottoNumber = Integer.parseInt(lottoNumber);

        validateLottoNumber(this.lottoNumber);
    }

    public LottoNumber(final int lottoNumber) {
        validateLottoNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void validateNullOrEmpty(final String lottoNumber) {
        if (StringUtils.isBlank(lottoNumber)) {
            throw new IllegalArgumentException(LottoNumberErrorCode.NOT_ALLOW_NULL.getMessage());
        }
    }

    private void validateLottoNumber(final Integer lottoNumber) {
        if (!isLottoNumberInRange(lottoNumber)) {
            throw new IllegalArgumentException(
                    String.format(
                            LottoNumberErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                            LOTTO_MIN_NUMBER,
                            LOTTO_MAX_NUMBER));
        }
    }

    private boolean isLottoNumberInRange(final Integer lottoNumber) {
        return lottoNumber >= LOTTO_MIN_NUMBER && lottoNumber <= LOTTO_MAX_NUMBER;
    }

    public int getLottoNumber() {
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
        return lottoNumber;
    }
}
