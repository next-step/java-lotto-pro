package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {

        if (isValidationCheckNullOrEmpty(text)) {
            return 0;
        }

        if (isNegativeNumbers(text)) {
            throw new RuntimeException("음수 값은 입력할 수 없습니다.");
        }

        return getSum(stringToNumberStrings(text));
    }

    private static boolean isValidationCheckNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isNegativeNumbers(String text) {
        return text.contains("-");
    }

    private static String[] stringToNumberStrings(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
