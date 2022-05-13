package calculator;

import java.util.Arrays;

import static calculator.utils.CalculatorStringSplitter.stringSplit;
import static calculator.utils.CalculatorValidator.isEmptyOrNull;
import static calculator.utils.CalculatorValidator.validatePositiveNumber;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        String[] strings = stringSplit(text);
        validatePositiveNumber(strings);

        return sum(strings);
    }

    private static int sum(String[] strings) {
        return Arrays.stream(strings).mapToInt(Integer::parseInt).sum();
    }
}
