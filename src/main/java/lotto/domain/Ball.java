package lotto.domain;

import java.util.Objects;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Ball implements Comparable<Ball> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public Ball(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(LottoErrorCode.INVALID_BALL);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball that = (Ball)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Ball that) {
        return Integer.compare(this.number, that.number);
    }
}
