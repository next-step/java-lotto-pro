package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int number;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final String VALUE_OUT_OF_RANGE_ERROR_MESSAGE = "제한된 범위를 벗어났습니다.";

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if(number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(VALUE_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
