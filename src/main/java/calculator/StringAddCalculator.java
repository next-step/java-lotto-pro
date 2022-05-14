package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        Splitter splitter = new Splitter(input);
        String[] arguments = splitter.getSplitResult();
        Calculator calculator = new Calculator(arguments);
        return calculator.sum();
    }
}
