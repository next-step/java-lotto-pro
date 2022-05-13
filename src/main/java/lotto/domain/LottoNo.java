package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoConstant.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstant.LOTTO_START_NUMBER;

public class LottoNo implements Comparable<LottoNo> {
    private final int number;

    public LottoNo(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
        }
        this.number = number;
    }

    public LottoNo(String number) {
        this(Integer.parseInt(number));
    }

    private boolean isInvalidNumber(int number) {
        return number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNo o) {
        return this.number - o.number;
    }
}
