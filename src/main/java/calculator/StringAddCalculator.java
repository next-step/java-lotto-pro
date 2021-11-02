package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String[] DELIMITER = {",", ":"};
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        String[] split = splitFrom(text, matcher);

        return calculateSum(split);
    }

    private static String[] splitFrom(String text, Matcher m) {
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        String delimiters = String.join("|", DELIMITER);
        return text.split(delimiters);
    }

    private static int calculateSum(String[] split) {
        return Arrays.stream(split)
                .mapToInt(StringAddCalculator::parseIntFrom)
                .sum();
    }

    private static int parseIntFrom(String text) {
        try {
            int number = Integer.parseInt(text);
            validateNegative(number);
            return number;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값에 숫자가 아닌 문자열이 포함되어 있습니다.");
        }
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("입력된 값에 음수가 있습니다.");
        }
    }
}
