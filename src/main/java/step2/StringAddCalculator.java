package step2;

import java.util.Arrays;

public class StringAddCalculator {

    public static final String REGEX_SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        if (validateBlank(text)) {
            return 0;
        }

        String[] split = text.split(REGEX_SEPARATOR);

        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean validateBlank(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }
}
