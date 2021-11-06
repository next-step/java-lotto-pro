package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_NUMBER_BOUND_ERROR.getMessage(), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    private boolean isValidNumber(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
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
