package calculator;

public class StringAddCalculator {
    private static CalculatorManager calculatorManager;

    public static int splitAndSum(String text) {
        calculatorManager = new CalculatorManager(text);

        return calculatorManager.getSum();
    }
}
