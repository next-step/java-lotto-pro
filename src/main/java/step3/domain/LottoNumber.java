package step3.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int RANGE_MIN_LOTTO_NUMBER = 1;
    public static final int RANGE_MAX_LOTTO_NUMBER = 45;
    public static final String RANGE_OVER_EXCEPTION = String.format("%s부터 %s 까지의 숫자를 입력해주세요.", RANGE_MIN_LOTTO_NUMBER,
        RANGE_MAX_LOTTO_NUMBER);

    private final int lotteNumber;

    public LottoNumber(int lotteNumber) {
        rangeNumberValid(lotteNumber);
        this.lotteNumber = lotteNumber;
    }

    public int toInt() {
        return lotteNumber;
    }

    private void rangeNumberValid(int lotteNumber) {
        if (lotteNumber < RANGE_MIN_LOTTO_NUMBER || lotteNumber > RANGE_MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(RANGE_OVER_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return lotteNumber == that.lotteNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteNumber);
    }
}
