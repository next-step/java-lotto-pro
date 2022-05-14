package calculator.domain;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int EMPTY_OUTPUT = 0;


    private StringAddCalculator() {
    }

    static int splitAndSum(String input) {

        if (isNullOrEmptyInput(input)) {
            return EMPTY_OUTPUT;
        }
        return ArrayCalculator.sum(StringUtils.toPositiveNumbers(StringSplitter.split(input)));
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

}
