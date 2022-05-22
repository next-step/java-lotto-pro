package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class LottoNumber {
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final String ERROR_VALID_NUMBER_RANGE_MESSAGE = "[ERROR] 1 ~ 45의 숫자만 입력가능합니다.";

    public final int number;

    public LottoNumber(int number) {
        checkValidationNumber(number);
        this.number = number;
    }

    private void checkValidationNumber(int number) {
        if (number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE)
            throw new IllegalArgumentException(ERROR_VALID_NUMBER_RANGE_MESSAGE);
    }

    public int getNumber() {
        return number;
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
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}

