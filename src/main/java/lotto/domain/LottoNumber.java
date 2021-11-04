package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d에서 %d 사이의 숫자를 입력하세요", MIN_NUMBER, MAX_NUMBER));
        }
        this.number = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public int value() {
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
}
