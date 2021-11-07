package lotto.domain;

import lotto.exception.LottoBallNumberRangeException;

import java.util.Objects;

public class LottoBall implements Comparable<LottoBall> {
    private final int number;

    public LottoBall(int number) {
        if (checkNumberRange(number)) {
            throw new LottoBallNumberRangeException("1~45 숫자를 입력해야 합니다.");
        }
        this.number = number;
    }

    private boolean checkNumberRange(int number) {
        return number < LottoBallRule.MIN_LOTTO_NUMBER.getNumber() || number > LottoBallRule.MAX_LOTTO_NUMBER.getNumber();
    }

    @Override
    public int compareTo(LottoBall other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall lottoBall = (LottoBall) o;
        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
