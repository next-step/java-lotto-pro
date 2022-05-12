package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String JOINER_PIPE = "|";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final Set<String> DELIMITER_GROUP = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(DELIMITER_COMMA, DELIMITER_COLON)));
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_SPLIT_DELIMITER_NUMBER = 1;
    private static final int CUSTOM_SPLIT_TARGET_NUMBER = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static int getSum(String[] splits) {
        return Arrays.stream(splits)
                .map(PositiveNumber::parseNotNegativeNumber)
                .mapToInt(PositiveNumber::getPositiveNumber)
                .sum();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_SPLIT_DELIMITER_NUMBER);
            return matcher.group(CUSTOM_SPLIT_TARGET_NUMBER).split(customDelimiter);
        }
        return input.split(String.join(JOINER_PIPE, DELIMITER_GROUP));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
