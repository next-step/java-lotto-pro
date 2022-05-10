package step2;

import java.util.Arrays;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String FRONT_CUSTOM_DELIMITER = "//";
    public static final String REAR_CUSTOM_DELIMITER = "\n";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        if (isSingleDigitNumber(input)) {
            return Integer.parseInt(input);
        }

        return getSumWithDelimiter(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
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
        input = getSubstringWithoutDelimiter(input);
        String[] numbers = input.split(delimiter);
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .filter(StringAddCalculator::isPositive)
                .reduce(0, Integer::sum);
    }

    private static String findDelimiter(String input) {
        if (input.startsWith(FRONT_CUSTOM_DELIMITER)) {
            return input.substring(FRONT_CUSTOM_DELIMITER.length(), input.indexOf(REAR_CUSTOM_DELIMITER));
        }
        return DEFAULT_DELIMITER;
    }

    private static String getSubstringWithoutDelimiter(String input) {
        return input.substring(input.indexOf(REAR_CUSTOM_DELIMITER) + REAR_CUSTOM_DELIMITER.length());
    }

    private static boolean isPositive(int num) {
        if (num >= 0) {
            return true;
        }
        throw new RuntimeException("음수는 포함될 수 없습니다.");
    }
}
