package lotto.domain.lotto;

import java.util.Objects;
import lotto.constant.LottoConstant;
import lotto.message.ErrorMessages;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateNumber(number);
        return new LottoNumber(number);
    }

    private static void validateNumber(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER || number > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_LOTTO_NUMBER, number));
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
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
