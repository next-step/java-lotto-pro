package calculator;

import calculator.domain.StringSplitter;
import calculator.domain.StringUtils;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");


    private static final StringSplitter splitter = new StringSplitter(DELIMITER, CUSTOM_DELIMITER_PATTERN);

    static int splitAndSum(String input) {

        if (isNullOrEmptyInput(input)) {
            return 0;
        }
        return sumNumbers(StringUtils.toPositiveNumbers(splitter.split(input)));
    }

    private static boolean isNullOrEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }


}
