package lotto.domain;

import lotto.domain.common.Constant;

import java.util.Objects;

public class LottoNumber {

    private static final String LOTTO_NUMBERS_RANGE_FROM_1_TO_45 = "Lotto numbers range from 1 to 45.";

    private final int lottoNumber;

    private LottoNumber(final int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(final int lottoNumber) {
        validate(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    public int getValue() {
        return lottoNumber;
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
