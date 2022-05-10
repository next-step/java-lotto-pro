package calculator;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringAddCalculator {
    private static final String JOINER_PIPE = "|";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static int getSum(String[] splits) {
        return Arrays.stream(splits)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] split(String input) {
        StringJoiner stringJoiner = new StringJoiner(JOINER_PIPE);
        stringJoiner.add(DELIMITER_COMMA);
        stringJoiner.add(DELIMITER_COLON);
        return input.split(stringJoiner.toString());
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
