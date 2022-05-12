package calculator.sum;

import calculator.number.PositiveNumber;
import calculator.number.PositiveNumbers;

public class SumNumbers {
    private final PositiveNumbers positiveNumbers;

    private int sumResult;

    public SumNumbers(PositiveNumbers positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    private void sum() {
        sumResult = 0;
        for (PositiveNumber positiveNumber : positiveNumbers.getPositiveNumbers()) {
            sumResult += positiveNumber.getNumber();
        }
    }

    public int getSumResult() {
        sum();
        return sumResult;
    }
}
