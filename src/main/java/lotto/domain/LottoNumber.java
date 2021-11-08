package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int FIRST_LOTTO_NUMBER = 1;
    public static final int LAST_LOTTO_NUMBER = 45;
    public static final String ERROR_MESSAGE_NUMBER_BOUND = "로또 숫자 범위를 초과하였습니다.";

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if (number < FIRST_LOTTO_NUMBER
                || number > LAST_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_BOUND);
        }
    }

    public String getNumberString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.number, lottoNumber.number);
    }
}
