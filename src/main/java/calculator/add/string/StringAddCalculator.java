package calculator.add.string;

import static calculator.add.string.utils.StringInputValidator.isBlank;
import static calculator.add.string.utils.StringInputValidator.validateIsPositiveInteger;

import calculator.add.string.utils.StringInputSplit;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        String[] inputNumbers = StringInputSplit.split(input);

        return sum(inputNumbers);
    }

    private static int sum(String[] inputNumbers) {
        int total = 0;

        for (String number : inputNumbers) {
            validateIsPositiveInteger(number);
            total += Integer.parseInt(number);
        }

        return total;
    }

}
