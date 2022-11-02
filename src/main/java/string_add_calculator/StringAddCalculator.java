package string_add_calculator;

import string_add_calculator.domain.Numbers;
import string_add_calculator.domain.SafeString;
import string_add_calculator.util.Splitter;

public class StringAddCalculator {
    private StringAddCalculator(){}

    public static int splitAndSum(String text) {
        SafeString safeString = SafeString.of(text);
        Numbers numbers = Splitter.split(safeString.toString());
        return numbers.sum();
    }
}
