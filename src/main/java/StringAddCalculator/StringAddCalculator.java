package StringAddCalculator;

import utils.CalculatorUtil;

public class StringAddCalculator {

    private static final int DEFAULT_INT = 0;

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return DEFAULT_INT;
        }
        String[] splitInput = CalculatorUtil.splitInput(input);
        return calculatorInput(splitInput);
    }

    private static int calculatorInput(String[] splitInput) {
        int result = DEFAULT_INT;
        for (String str : splitInput) {
            result += CalculatorUtil.checkPositiveNum(str);
        }
        return result;
    }

}
