package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    private static final String LOTTO_NUMBER_ERROR = "[ERROR] 로또 숫자는 1 ~ 45 사이의 숫자야 합니다.";

    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (MIN_LOTTO_NUM > number || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
