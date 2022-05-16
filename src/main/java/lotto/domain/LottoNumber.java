package lotto.domain;

import java.util.Objects;

import static lotto.constants.LottoNumberConstant.*;
import static lotto.constants.LottoGameErrorMessage.*;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    private void validateNumberInRange(int number) {
        if (number < LOTTO_NUMBER_MINIMUM_VALUE || number > LOTTO_NUMBER_MAXIMUM_VALUE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
