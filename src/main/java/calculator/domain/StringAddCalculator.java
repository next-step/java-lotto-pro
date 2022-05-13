package calculator.domain;

import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");


    private static final StringSplitter splitter = new StringSplitter(DELIMITER, CUSTOM_DELIMITER_PATTERN);

    static int splitAndSum(String input) {

        if (isNullOrEmptyInput(input)) {
            return 0;
        }
        return ArrayCalculator.sum(StringUtils.toPositiveNumbers(splitter.split(input)));
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

}
