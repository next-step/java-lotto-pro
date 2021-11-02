package step2;

import java.util.Arrays;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = text.split(DEFAULT_DELIMITER_REGEX);

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
