package lotto.domain;

import lotto.domain.error.LottoNumberErrorCode;
import lotto.infrastructure.util.StringUtils;

public class LottoNumber {

    public static final int MIN = 1;
    public static final int MAX = 45;

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
                            LottoNumberErrorCode.INVALID_LOTTO_NUMBER.getMessage(), MIN, MAX));
        }
    }

    private boolean isLottoNumberInRange(final Integer lottoNumber) {
        return lottoNumber >= MIN && lottoNumber <= MAX;
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
