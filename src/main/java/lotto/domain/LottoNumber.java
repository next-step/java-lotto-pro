package lotto.domain;

import java.util.Objects;

import static lotto.constant.LottoConfig.FIRST_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.LAST_LOTTO_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if (number < FIRST_LOTTO_NUMBER
                || number > LAST_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자 범위를 초과하였습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.number, lottoNumber.number);
    }
}
