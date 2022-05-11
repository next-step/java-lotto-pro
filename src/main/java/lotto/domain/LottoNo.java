package lotto.domain;

import java.util.Objects;

public class LottoNo {
    private int number;

    public LottoNo(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
        }
        this.number = number;
    }

    private boolean isInvalidNumber(int number) {
        if (number < LottoConstant.LOTTO_START_NUMBER || number > LottoConstant.LOTTO_END_NUMBER) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
