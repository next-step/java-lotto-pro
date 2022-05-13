package calculator.add.string;

import static calculator.add.string.utils.StringInputUtil.isBlank;
import static calculator.add.string.utils.StringInputUtil.split;

import calculator.add.string.model.Numbers;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        Numbers numbers = new Numbers(split(input));

        return numbers.sumTotal();
    }

}
