package step2;

import java.util.Arrays;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String FRONT_CUSTOM_DELIMITER = "//";
    public static final String REAR_CUSTOM_DELIMITER = "\n";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
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
        String delimiter = findDelimiter(input);
        input = input.substring(input.indexOf(REAR_CUSTOM_DELIMITER) + 1);
        String[] numbers = input.split(delimiter);
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .filter(num -> isPositive(num))
                .reduce(0, (num1, num2) -> num1 + num2);
    }

    private static boolean isPositive(int num) {
        if (num >= 0) {
            return true;
        }
        throw new RuntimeException("음수는 포함될 수 없습니다.");
    }

    private static String findDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITER;
        if (input.startsWith(FRONT_CUSTOM_DELIMITER)) {
            return input.substring(FRONT_CUSTOM_DELIMITER.length(), input.indexOf(REAR_CUSTOM_DELIMITER));
        }
        return delimiter;
    }
}
