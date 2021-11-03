package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        try {
            return Arrays.stream(text.split("[,:]"))
                    .mapToInt(Integer::parseInt)
                    .map(StringAddCalculator::parsePositiveInteger)
                    .sum();
        } catch (NumberFormatException ignored) {
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .map(StringAddCalculator::parsePositiveInteger)
                    .sum();
        }
        return 0;
    }

    private static int parsePositiveInteger(Integer integer) {
        if (integer < 0) {
            throw new RuntimeException();
        }
        return integer;
    }
}
