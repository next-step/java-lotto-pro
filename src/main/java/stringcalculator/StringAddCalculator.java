package stringcalculator;

import static stringcalculator.utils.PositiveIntegerConverter.convertToPositiveIntegers;
import static stringcalculator.utils.StringBlankChecker.isBlank;
import static stringcalculator.utils.StringSplitter.split;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(convertToPositiveIntegers(split(input)));
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
