package calculator;

import calculator.util.Validator;

public class StringAddCalculator {
    private final Calculator calculator = new Calculator();
    private final Spliter spliter = new Spliter();

    public int splitAndSum(String text) {
        if(Validator.isNullOrEmpty(text))
            return 0;
        return calculator.sum(spliter.split(text));
    }
}
