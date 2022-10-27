package lotto.domain;

import java.util.Objects;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumber {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1~45 사이의 숫자여야 합니다.";
    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    private void validate(int value) {
        if (value < MINIMUM_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException(INVALID_LOTTO_NUMBER_MESSAGE);
        }
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
}
