package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final LottoNumber[] LOTTO_NUMBERS_CACHE = new LottoNumber[END_INCLUSIVE + 1];

    static {
        IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .forEach(number -> LOTTO_NUMBERS_CACHE[number] = new LottoNumber(number));
    }

    private final int lottoNumber;

    public LottoNumber(int number) {
        validateRange(number);
        this.lottoNumber = number;
    }

    private static void validateRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public static LottoNumber valueOf(final int number) {
        validateRange(number);
        return LOTTO_NUMBERS_CACHE[number];
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

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.lottoNumber - other.lottoNumber;
    }
}
