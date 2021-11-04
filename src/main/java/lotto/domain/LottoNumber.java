package lotto.domain;

import lotto.domain.exception.RangeOutOfLottoNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        validate(lottoNumber);

        return lottoNumber;
    }

    private static void validate(final LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new RangeOutOfLottoNumberException();
        }
    }

    public int getValue() {
        return number;
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
