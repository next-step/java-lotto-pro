package lotto.domain;

import lotto.domain.common.Constant;

import java.util.Objects;

public class LottoNumber {

    private static final String LOTTO_NUMBERS_RANGE_FROM_1_TO_45 = "Lotto numbers range from 1 to 45.";

    private final int num;

    private LottoNumber(final int num) {
        this.num = num;
    }

    public static LottoNumber from(final int num) {
        validate(num);
        return new LottoNumber(num);
    }

    public int getValue() {
        return num;
    }

    private static void validate(final int num) {
        if( !(num >= Constant.LOTTO_MIN && num <= Constant.LOTTO_MAX) ){
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_FROM_1_TO_45);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
