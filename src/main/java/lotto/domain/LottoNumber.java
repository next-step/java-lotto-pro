package lotto.domain;

import java.util.Objects;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import view.Printable;

public class LottoNumber implements Comparable<LottoNumber>, Printable {
    private final int number;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    public LottoNumber(int number) {
        checkValidLottoNumber(number);
        this.number = number;
    }

    private void checkValidLottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber that) {
        return Integer.compare(this.number, that.number);
    }

    @Override
    public String makePrintableMessage() {
        return String.valueOf(number);
    }
}
