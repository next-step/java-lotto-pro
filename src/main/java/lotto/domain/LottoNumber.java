package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final LottoNumber[] LOTTO_NUMBER;
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private static final int ARRAY_MINUS = 1;

    static {
        LOTTO_NUMBER = IntStream.range(BEGIN_NUMBER, END_NUMBER)
                .mapToObj(LottoNumber::new)
                .toArray(LottoNumber[]::new);
    }

    private final int lottoNumber;

    public static LottoNumber of(final int inputNumber) {
        validate(inputNumber);
        return LOTTO_NUMBER[inputNumber - ARRAY_MINUS];
    }

    private LottoNumber(final int inputNumber) {
        this.lottoNumber = inputNumber;
    }

    private static void validate(int inputNumber) {
        if (inputNumber < BEGIN_NUMBER || inputNumber >= END_NUMBER) {
            throw new IllegalArgumentException("범위 값오류");
        }
    }

    public int getLottoNumber() {
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
