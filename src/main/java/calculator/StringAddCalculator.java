package calculator;

import calculator.number.PositiveNumbers;
import calculator.sum.SumNumbers;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        PositiveNumbers positiveNumbers = PositiveNumbers.newInstance(text);
        SumNumbers sumNumbers = new SumNumbers(positiveNumbers);
        return sumNumbers.sumResult();
    }
}
