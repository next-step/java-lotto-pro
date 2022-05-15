package stringcalculator;

import static stringcalculator.utils.PositiveNumberConverter.convertToPositiveNumbers;
import static stringcalculator.utils.StringBlankChecker.isBlank;
import static stringcalculator.utils.StringSplitter.split;

import java.util.List;
import stringcalculator.vo.PositiveNumber;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(convertToPositiveNumbers(split(input)));
    }

    private static int sum(List<PositiveNumber> numbers) {
        PositiveNumber result = PositiveNumber.from(0);
        for (PositiveNumber number : numbers) {
            result.add(number);
        }
        return result.getPositiveNumber();
    }
}
