package calculator;

import calculator.utils.ValidationUtils;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (ValidationUtils.isNullOrEmpty(input)) {
            return 0;
        }
        Numbers numbers = new Numbers(input);
        return numbers.sum();
    }
}
