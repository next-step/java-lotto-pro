package step2;

import java.util.Arrays;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String FRONT_CUSTOM_DELIMITER = "//";
    public static final String REAR_CUSTOM_DELIMITER = "\n";

    public static int splitAndSum(String input) {
        if (input == null) {
            return 0;
        }

        if (input.isEmpty()) {
            return 0;
        }

        if (isSingleDigitNumber(input)) {
            return Integer.valueOf(input);
        }

        return getSumWithDelimiter(input);
    }

    static boolean isSingleDigitNumber(String input) {
        try {
            Integer.valueOf(input);
            return input.length() == 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getSumWithDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITER;
        if (input.startsWith(FRONT_CUSTOM_DELIMITER)) {
            delimiter = findCustomDelimeter(input);
            input = input.substring(input.indexOf(REAR_CUSTOM_DELIMITER) + 1);
        }
        String[] numbers = input.split(delimiter);
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .reduce(0, (num1, num2) -> num1 + num2);
    }

    private static String findCustomDelimeter(String input) {
        return input.substring(FRONT_CUSTOM_DELIMITER.length(), input.indexOf(REAR_CUSTOM_DELIMITER));
    }
}
