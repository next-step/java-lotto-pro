package calculator;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String JOINER_PIPE = "|";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int SPLIT_DELIMITER_GROUP = 1;
    private static final int SPLIT_TARGET_GROUP = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static int getSum(String[] splits) {
        return Arrays.stream(splits)
                .map(ParseNumber::parseNotNegativeInt)
                .mapToInt(ParseNumber::getParseNumber)
                .sum();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(SPLIT_DELIMITER_GROUP);
            return matcher.group(SPLIT_TARGET_GROUP).split(customDelimiter);
        }
        StringJoiner stringJoiner = new StringJoiner(JOINER_PIPE);
        stringJoiner.add(DELIMITER_COMMA);
        stringJoiner.add(DELIMITER_COLON);
        return input.split(stringJoiner.toString());
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
