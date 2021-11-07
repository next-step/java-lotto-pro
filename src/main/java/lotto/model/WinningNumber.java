package lotto.model;

import lotto.exception.InvalidInputException;

import static lotto.common.Constants.MAX_RANGE_VALUE;
import static lotto.common.Constants.MIN_RANGE_VALUE;

public class WinningNumber {

    private static final String INVALID_WINNING_NUMBER_MESSAGE = "%s-%s 사이의 숫자만 입력할 수 있습니다.";

    private Integer value;

    public WinningNumber(String value) {
        this.value = Integer.parseInt(value);
        validateWinningNumber();
    }

    /**
     * 입력값 유효성검사
     * 입력값이 MIN_RANGE_VALUE와 MAX_RANGE_VALUE의 사이에 포함되지 않으면 예외처리를 합니다.
     */
    private void validateWinningNumber() {
        if (value < MIN_RANGE_VALUE || value > MAX_RANGE_VALUE) {
            throw new InvalidInputException(String.format(INVALID_WINNING_NUMBER_MESSAGE, MIN_RANGE_VALUE, MAX_RANGE_VALUE));
        }
    }

    public Integer getValue() {
        return value;
    }

}
