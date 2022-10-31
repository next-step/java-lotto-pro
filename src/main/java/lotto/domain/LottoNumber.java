package lotto.domain;

import java.util.Objects;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumber {

    private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1~45 사이의 숫자여야 합니다.";
    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber from(int value) {
        return new LottoNumber(value);
    }

    private void validate(int value) {
        if (invalidLottoNumber(value)) {
            throw new InvalidLottoNumberException(INVALID_LOTTO_NUMBER_MESSAGE);
        }
    }

    private static boolean invalidLottoNumber(int value) {
        return value < LottoInfo.MIN_LOTTO_NUMBER.getValue() || value > LottoInfo.MAX_LOTTO_NUMBER.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
