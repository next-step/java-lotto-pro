package lotto.domain;

import java.util.Objects;

/**
 * packageName : lotto.domain
 * fileName : LottoNumber
 * author : haedoang
 * date : 2021/11/04
 * description :
 */
public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) throw new IllegalArgumentException("1부터 45 사이의 숫자만 가능합니다.");
        this.number = number;
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

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
