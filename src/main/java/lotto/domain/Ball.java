package lotto.domain;


import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;

import java.util.Objects;

public class Ball {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private int number;

    public Ball(int number) {
        checkValidNumber(number);
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    private void checkValidNumber(int number) {
        if (!isRangeBetweenOneAndFortyFive(number)) {
            throw new InputDataException(InputDataErrorCode.INVALID_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isRangeBetweenOneAndFortyFive(int number) {
        return MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER;
    }

    @Override
    public String toString() {
        return String.join(",", String.valueOf(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return this.number() == ball.number();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
