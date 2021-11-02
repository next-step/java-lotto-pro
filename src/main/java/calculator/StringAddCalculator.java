package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DELIMITER = ",|:";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return isCustomDelimiter(text);
    }

    private static int isCustomDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(toInts(tokens));
        }
        return sum(toInts(split(text)));
    }

    private static int sum(int[] values) {
        return Arrays.stream(values).sum();
    }

    private static int[] toInts(String[] values) {
        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }

    private static String[] split(String text) {
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
