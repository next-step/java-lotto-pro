package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final String INPUT_LOTTO_ERROR = "잘못된 로또 번호를 입력하였습니다.";

    private int number;

    private LottoNumber(int number) {
        isValidRange(number);
        this.number = number;
    }
    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public LottoNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            isValidRange(number);
            this.number = number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_LOTTO_ERROR);
        }
    }

    private void isValidRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INPUT_LOTTO_ERROR);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
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
