package step3;

import java.util.Objects;
import util.Numbers;

public class LottoNumber {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        verifyLottoNumber(number);

        this.number = number;
    }

    private void verifyLottoNumber(final int number) {
        if (Numbers.isNegative(number)) {
            throw new IllegalArgumentException("음수를 로또 번호로 할 수 없습니다.");
        }

        if (!isAvailableLottoNumber(number)) {
            throw new IllegalArgumentException("잘못 된 로또 번호입니다.");
        }
    }

    private boolean isAvailableLottoNumber(final int number) {
        return number >= MINIMUM_LOTTO_NUMBER && number <= MAXIMUM_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        final LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
