package calculator.domain;

import calculator.constant.ErrorCode;

/**
 * StringAddCalculator에서 덧셈 시 사용할 숫자값 Wrapping 클래스
 */
public class PositiveNumber {

    private final int positiveNumber;

    public PositiveNumber(String textNumber) {
        int number = parseNumber(textNumber);
        validatePositiveNumber(number);
        this.positiveNumber = number;
    }

    private int parseNumber(String textNumber) {
        try {
            return Integer.parseInt(textNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.정수값이_아님.getErrorMessage());
        }
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
