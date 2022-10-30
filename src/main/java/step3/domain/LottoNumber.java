package step3.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final String LOTTO_NUMBER_OUT_OF_RANGE = "로또 숫자의 범위는 1 ~ 45 이내여야 합니다.";
    private final int number;

    public LottoNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private static void validateNumberRange(final int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
