package lotto.model;

import java.util.Objects;

import static lotto.constant.Config.LOTTO_MAX_NUMBER;
import static lotto.constant.Config.LOTTO_MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        this.validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
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
}
