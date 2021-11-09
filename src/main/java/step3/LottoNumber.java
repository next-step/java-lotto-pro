package step3;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(final int number) {
        verifyLottoNumber(number);

        this.number = number;
    }

    private void verifyLottoNumber(final int number) {
        if (isNegativeLottoNumber(number)) {
            throw new IllegalArgumentException("음수를 로또 번호로 할 수 없습니다.");
        }

        if (!isAvailableLottoNumber(number)) {
            throw new IllegalArgumentException("잘못 된 로또 번호입니다.");
        }
    }

    private boolean isAvailableLottoNumber(final int number) {
        return number >= 1 && number <= 45;
    }

    private boolean isNegativeLottoNumber(final int number) {
        return number < 0;
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
