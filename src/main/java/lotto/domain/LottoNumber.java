package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOWER_BOUND = 0;
    public static final int UPPER_BOUND = 45;
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOWER_BOUND || UPPER_BOUND < number) {
            throw new IllegalArgumentException("1이상 45 이하의 숫자를 입력해주세요");
        }
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
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.number) {
            return 1;
        }
        if (this.number < o.number) {
            return -1;
        }
        return 0;
    }
}
