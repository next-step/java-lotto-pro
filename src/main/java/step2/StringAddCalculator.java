package step2;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DELEMETER = ",|:";

    public static int splitAndSum(String inputString) {
        if (isEmpty(inputString)) {
            return 0;
        }
        if (isNumber(inputString)) {
            return Integer.parseInt(inputString);
        }

        String[] numbers = splitString(inputString);
        return sum(numbers);
    }

    private static boolean isEmpty(String source) {
        return source == null || source.isEmpty();
    }

    private static boolean isNumber(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[] splitString(String inputString) {
        return inputString.split(DELEMETER);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
