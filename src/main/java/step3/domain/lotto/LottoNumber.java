package step3.domain.lotto;

import java.util.Objects;

import static step3.type.ErrorMessageType.LOTTO_NUMBER_CANNOT_BE_GREATER_THAN_END_INCLUSIVE;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_CANNOT_BE_LESS_THAN_START_INCLUSIVE;

public class LottoNumber {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateRange(final int lottoNumber) {
        if (lottoNumber < START_INCLUSIVE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CANNOT_BE_LESS_THAN_START_INCLUSIVE.getMessage());
        }
        if (lottoNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CANNOT_BE_GREATER_THAN_END_INCLUSIVE.getMessage());
        }
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
