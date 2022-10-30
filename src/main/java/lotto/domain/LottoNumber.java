package lotto.domain;

import static lotto.util.LottoUtil.*;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(Integer number) {
        if (number > END_NUMBER || number < BEGIN_NUMBER) {
            throw new IllegalStateException("유효한 숫자 범위가 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LottoNumber that = (LottoNumber)o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

}
