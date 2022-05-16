package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int lottoNumber;

    public LottoNumber(final int inputNumber) {
        validate(inputNumber);
        this.lottoNumber = inputNumber;
    }

    private void validate(int inputNumber) {
        if (inputNumber < MIN || inputNumber > MAX) {
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
