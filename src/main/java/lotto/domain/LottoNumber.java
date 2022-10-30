package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if(MIN > number || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하의 숫자만 가능합니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber number) {
        return this.number - number.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return this.number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
