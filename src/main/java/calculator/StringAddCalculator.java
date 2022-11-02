package calculator;

import calculator.domain.Numbers;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if (validateEmptyInput(input)) {
            return 0;
        }

        Numbers numbers = new Numbers(input);

        return numbers.addElements();

    }

    private static boolean validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }



}
