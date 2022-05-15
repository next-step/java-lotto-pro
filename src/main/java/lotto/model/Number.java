package lotto.model;

import java.util.Objects;

public class Number {
    private final int lottoNumber;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Number(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        invalidRangeCheck();
    }

    public Number(String lottoNumber) {
        invalidInputCheck(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
        invalidRangeCheck();
    }

    private void invalidInputCheck(String lottoNumber) {
        try {
            Integer.parseInt(lottoNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    private void invalidRangeCheck() {
        if(lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 범위의 숫자입니다.");
        }
    }

    @Override
    public String toString() {
        return lottoNumber + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return lottoNumber == number.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
