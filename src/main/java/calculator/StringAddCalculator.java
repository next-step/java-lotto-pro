package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static int CUSTOM_PATTERN_DELIMITER_INDEX = 1;
    private final static int CUSTOM_SPLIT_DELIMITER_INDEX = 2;
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
            String customDelimiter = m.group(CUSTOM_PATTERN_DELIMITER_INDEX);
            return m.group(CUSTOM_SPLIT_DELIMITER_INDEX).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(token -> {
            try {
                return Integer.parseInt(token);
            }catch (NumberFormatException e) {
                throw new RuntimeException("숫자 값만 계산이 가능합니다.");
            }
        }).sum();
    }
}
