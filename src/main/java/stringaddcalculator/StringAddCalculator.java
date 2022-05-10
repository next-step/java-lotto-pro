package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String COMMA_AND_COLON = ",|:";
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    public static final String NUMERIC_PATTERN = "\\d";

    public static int splitAndSum(final String text) {
        if (validateNullOrEmpty(text)) {
            return ZERO;
        }

        final String[] splitTexts = splitText(text);
        final int[] numbers = parsingNumbers(splitTexts);

        return sumNumbers(numbers);
    }

    private static boolean validateNullOrEmpty(final String text) {
        if (text == null) {
            return true;
        }
        return text.isEmpty();
    }

    private static String[] splitText(final String text) {
        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);

        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(COMMA_AND_COLON);
    }

    private static int[] parsingNumbers(final String[] splitTexts) {
        final int length = splitTexts.length;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = parseInteger(splitTexts[i]);
        }

        return numbers;
    }

    private static int parseInteger(final String text) {
        validateNumeric(text);
        return parsePositiveInteger(text);
    }

    private static int parsePositiveInteger(final String text) {
        final int i = Integer.parseInt(text);

        if (isMinus(i)) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }

        return i;
    }

    private static int sumNumbers(final int[] numbers) {
        int sum = 0;

        for (final int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static void validateNumeric(final String text) {
        if (!text.matches(NUMERIC_PATTERN)) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static boolean isMinus(final int i) {
        return i < 0;
    }

}
