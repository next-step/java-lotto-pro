package calculator.domain;

import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int EMPTY_OUTPUT = 0;

    private static final StringSplitter splitter = new StringSplitter(DELIMITER, CUSTOM_DELIMITER_PATTERN);

    private StringAddCalculator() {
    }

    static int splitAndSum(String input) {

        if (isNullOrEmptyInput(input)) {
            return EMPTY_OUTPUT;
        }
        return ArrayCalculator.sum(StringUtils.toPositiveNumbers(splitter.split(input)));
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

}
