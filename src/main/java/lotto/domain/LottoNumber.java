package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int LOTTO_MIN_NUMBER = 1;

    private final int LOTTO_MAX_NUMBER = 45;

    private final String LOTTO_OUT_RANGE_MESSAGE = "로또 번호는 1이상 45이하의 숫자만 가능합니다.";

    private final int lottoNumber;

    public LottoNumber(final int number) {
        validate(number);
        this.lottoNumber = number;
    }

    private void validate(final int number) {
        validateRange(number);
    }

    private void validateRange(final int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_OUT_RANGE_MESSAGE);
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
