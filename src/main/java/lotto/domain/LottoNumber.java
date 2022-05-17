package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final String ERROR_MSG_NUMBER_RANGE = "로또 번호가 범위에서 벗어났습니다.";
    private static final String ERROR_MSG_NOT_NUMBER = "로또 번호는 숫자로만 입력해 주세요.";
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String lottoNumber) {
        validateNumber(lottoNumber);
        validateRange(Integer.parseInt(lottoNumber));
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validateRange(int lottoNumber) {
        if (lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MSG_NUMBER_RANGE);
        }
    }

    private void validateNumber(String lottoNumber) {
        try {
            Integer.parseInt(lottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_NUMBER);
        }
    }

    private int minus(int number) {
        return this.lottoNumber - number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return lottoNumber.minus(this.lottoNumber) * -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
