package calculator;

import calculator.util.Validator;

public class StringAddCalculator {
    private final Calculator calculator = new Calculator();
    private final Spliter spliter = new Spliter();
    private final Validator validator = new Validator();

    public int splitAndSum(String text) {
        if(validator.isNullOrEmpty(text))
            return 0;
        return calculator.sum(spliter.split(text));
    }
}
