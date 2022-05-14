package calculator;

import calculator.domain.PlusStrategyFactory;
import calculator.domain.PlusStrategy;

public class StringAddCalculator {
    public static int splitAndSum(String expressionStr) {
        PlusStrategyFactory plusStrategyFactory = new PlusStrategyFactory();
        PlusStrategy strategy = plusStrategyFactory.getStrategy(expressionStr);
        return strategy.result(expressionStr);
    }
}
