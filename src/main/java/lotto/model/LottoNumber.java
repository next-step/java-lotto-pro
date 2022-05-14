package lotto.model;

import java.util.Objects;

public class LottoNumber {
    public final static int MIN_LOTTO_NUMBER = 1;
    public final static int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if(MIN_LOTTO_NUMBER > number || MAX_LOTTO_NUMBER < number){
            throw new IllegalArgumentException("1~45 숫자만 유효합니다.");
        }
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
        return String.valueOf(number);
    }
}
