package lotto.model;

import lotto.LottoConstants;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < LottoConstants.MIN_VALUE || number > LottoConstants.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        this.number = number;
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
}
