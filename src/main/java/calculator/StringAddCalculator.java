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
        return sum(toInts(split(text)));
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            validateNegative(value);
            sum += value;
        }
        return sum;
    }

    private static void validateNegative(int value) {
        if (value < 0) {
            throw new RuntimeException("음수를 입력하였습니다.");
        }
    }

    private static int[] toInts(String[] values) {
        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
