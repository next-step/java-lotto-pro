package lotto.domain;

import lotto.exception.LottoNumberRangeException;

import java.util.Objects;

import static lotto.common.LottoConst.MAX_NUMBER;
import static lotto.common.LottoConst.MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(final int number) {
        this.number = number;
        validation();
    }

    private void validation() {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoNumberRangeException();
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
}
