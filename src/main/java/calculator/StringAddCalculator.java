package calculator;

import calculator.domain.Nums;
import calculator.util.Common;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if (Common.validateEmptyInput(input)) {
            return 0;
        }

        Nums nums = new Nums(input);

        return nums.addElements();

    }




}
