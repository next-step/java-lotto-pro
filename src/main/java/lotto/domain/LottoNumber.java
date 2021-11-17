package lotto.domain;

import static java.text.MessageFormat.*;
import static util.NumberUtils.*;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        verifyLottoNumber(number);

        this.number = number;
    }

    public int findWinningCount(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.contains(this)) {
            return 1;
        }

        return ZERO;
    }

    private void verifyLottoNumber(final int number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException("로또 번호는 음수일 수 없습니다.");
        }

        if (!isAvailableLottoNumber(number)) {
            throw new IllegalArgumentException(
                format("로또 번호는 {0} ~ {1} 까지 가능합니다.", MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
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

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
