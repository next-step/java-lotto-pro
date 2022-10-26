package calculator.domain;

import calculator.constant.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/**
 * PositiveNumber List Collection Wrapping 클래스
 */
public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(String[] textNumbers) {
        List<PositiveNumber> positiveNumbers = new ArrayList<>();
        for(String textNumber: textNumbers) {
            positiveNumbers.add(new PositiveNumber(textNumber));
        }
        this.positiveNumbers = positiveNumbers;
    }

    public int sumAll() {
        int sum = 0;
        for(PositiveNumber positiveNumber: positiveNumbers) {
            sum += positiveNumber.getPositiveNumber();
            checkPositiveNumberRange(sum);
        }
        return sum;
    }

    private void checkPositiveNumberRange(int sum) {
        if(sum < 0) {
            throw new IllegalArgumentException(ErrorCode.덧셈_결과_INT_양의_범위_넘김.getErrorMessage());
        }
    }
}
