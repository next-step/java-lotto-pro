package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String INVALID_BETWEEN_MIN_AND_MAX = "로또 번호는 1 ~ 45 중에서 골라주세요.";
    private final int number;

    public LottoNumber(int number) {
        validateBetweenMinAndMax(number);
        this.number = number;
    }

    private void validateBetweenMinAndMax(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_BETWEEN_MIN_AND_MAX);
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
