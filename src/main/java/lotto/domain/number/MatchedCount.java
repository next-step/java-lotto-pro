package lotto.domain.number;

import lotto.exception.OutOfBoundException;

public class MatchedCount extends Number {
    private static final int MATCHED_COUNT_MIN = 0;
    private static final int MATCHED_COUNT_MAX = 6;

    private MatchedCount(int number) {
        super(number);
        validate(number);
    }

    public static MatchedCount from(int number) {
        return new MatchedCount(number);
    }

    @Override
    protected void validate(int number) {
        if (number < MATCHED_COUNT_MIN) {
            throw OutOfBoundException.valueIsLessThan(number);
        }

        if (number > MATCHED_COUNT_MAX) {
            throw OutOfBoundException.valueIsGreaterThan(number);
        }
    }

}
