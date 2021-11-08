package step3.domain;

import java.util.Objects;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class LottoNumber {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    private final int number;

    public LottoNumber(int number) {
        validRange(number);
        this.number = number;

    }

    public Integer value() {
        return number;
    }

    private void validRange(int number) {
        if (isArrowedRange(number)) {
            throw new InvalidParamException(LottoConstant.LOTTO_RANGE_OVER_EXCEPTION);
        }
    }

    private boolean isArrowedRange(int number) {
        return number < LottoConstant.MIN_NUMBER_RANGE || number > LottoConstant.MAX_NUMBER_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
