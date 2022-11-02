package lotto.domain;

import lotto.view.Error;
import lotto.view.OutputView;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_RANGE);
        }
        this.number = number;
    }

    public static boolean isValid(int number) {
        if (MIN > number || number > MAX) {
            OutputView.print(Error.LOTTO_NUMBER_RANGE);
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(LottoNumber number) {
        return this.number - number.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return this.number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
