package lotto;

import java.util.Objects;

public class LottoNumber {

    private final String VALUE_OUT_OF_RANGE_ERROR_MESSAGE = "제한된 범위를 벗어났습니다.";
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(number < 1 || number > 45) {
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
}
