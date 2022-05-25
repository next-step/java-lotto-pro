package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final LottoNumber[] COLLECTION;
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private static final int ARRAY_MINUS = 1;

    static {
        COLLECTION = IntStream.range(BEGIN_NUMBER, END_NUMBER)
                .mapToObj(LottoNumber::new)
                .toArray(LottoNumber[]::new);
    }

    private final int value;

    public static LottoNumber ofString(final String inputNumber) {
      return of(Integer.parseInt(inputNumber));
    }

    public static LottoNumber of(final int inputNumber) {
        validate(inputNumber);
        return COLLECTION[inputNumber - ARRAY_MINUS];
    }

    private LottoNumber(final int inputNumber) {
        this.value = inputNumber;
    }

    private static void validate(int inputNumber) {
        if (inputNumber < BEGIN_NUMBER || inputNumber >= END_NUMBER) {
            throw new LottoException(LottoExceptionType.LOTTO_RANGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + value +
                '}';
    }
}
