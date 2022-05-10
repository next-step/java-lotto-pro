package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (isValidationCheckNullOrEmpty(text)) {
            return 0;
        }

        return standardStringAddCalculator(text);
    }

    private static boolean isValidationCheckNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int standardStringAddCalculator(String text) {
        String[] tokens = text.split(",|:");

        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
