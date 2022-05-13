package study;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_REGEX = "//(.+)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);
    private static final int CUSTOM_DELIMITER = 1;
    private static final int SPLIT_WORD = 2;
    private static final int ZERO = 0;
    private static final String EMPTY = "";
    private static final String NEGATIVE_NUMBER_ERROR = "음수는 사용 불가능 합니다.";

    public static int splitAndSum(final String word) {
        if (isEmpty(word)) {
            return ZERO;
        }

        return sum(toNumbers(split(word)));
    }

    private static boolean isEmpty(final String word) {
        return word == null || EMPTY.equals(word);
    }

    private static String[] split(final String word) {
        Matcher matcher = CUSTOM_PATTERN.matcher(word);
        if (matcher.find()) {
            return splitCustom(matcher);
        }
        return splitDefault(word);
    }

    private static int sum(final int[] numbers) {
        isValid(numbers);
        return Arrays.stream(numbers).sum();
    }

    private static int[] toNumbers(final String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[] splitCustom(final Matcher matcher) {
        return matcher.group(SPLIT_WORD).split(matcher.group(CUSTOM_DELIMITER));
    }

    private static String[] splitDefault(final String word) {
        return word.split(DEFAULT_DELIMITER);
    }

    private static void isValid(final int[] numbers) {
        boolean negativeNumber = Arrays.stream(numbers)
                .anyMatch(StringCalculator::lessThenZero);

        if (negativeNumber) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }

    private static <T extends Number> boolean lessThenZero(final T number) {
        return number.intValue() < ZERO;
    }
}