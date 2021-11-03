package lotto.domain;

import lotto.domain.exception.RangeOutOfLottoNumberException;

import java.util.Objects;

public final class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(final int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(final int lottoNumber) {
        validate(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    private static void validate(final int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new RangeOutOfLottoNumberException();
        }
    }

    public int getValue() {
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
        return Objects.hash(lottoNumber);
    }

}
