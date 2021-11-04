package lotto.domain;


import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;

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
}
