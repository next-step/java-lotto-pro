package calculator.domain;

import common.constant.ErrorCode;
import common.utils.IntegerUtils;

/**
 * StringAddCalculator에서 덧셈 시 사용할 숫자값 Wrapping 클래스
 */
public class PositiveNumber {

    private final int positiveNumber;

    public PositiveNumber(String textNumber) {
        int number = IntegerUtils.parseInt(textNumber);
        validatePositiveNumber(number);
        this.positiveNumber = number;
    }

    private void validatePositiveNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException(ErrorCode.음의_정수가_입력되면_안됨.getErrorMessage());
        }
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }
}
