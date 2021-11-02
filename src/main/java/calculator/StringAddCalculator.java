package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return Arrays.stream(splitTokens(input))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] splitTokens(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split("[,:]");
    }
}
