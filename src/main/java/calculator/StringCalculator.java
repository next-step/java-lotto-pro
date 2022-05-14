package calculator;

import static calculator.StringUtils.*;
import static calculator.ColletionUtils.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_REGEX = "//(.+)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);
    private static final int CUSTOM_DELIMITER = 1;
    private static final int SPLIT_WORD = 2;
    private static final int ZERO = 0;

    private static final String NEGATIVE_NUMBER_ERROR = "음수는 사용 불가능 합니다.";

    public static int splitAndSum(final String word) {
        if (isEmpty(word)) {
            return ZERO;
        }

        return sum(toNumbers(split(word)));
    }

    private static int sum(final int[] numbers) {
        validate(numbers);
        return Arrays.stream(numbers).sum();
    }

    private static String[] split(final String word) {
        Matcher matcher = CUSTOM_PATTERN.matcher(word);
        if (matcher.find()) {
            return splitCustom(matcher);
        }
        return splitDefault(word);
    }

    private static String[] splitCustom(final Matcher matcher) {
        return matcher.group(SPLIT_WORD).split(matcher.group(CUSTOM_DELIMITER));
    }

    private static String[] splitDefault(final String word) {
        return word.split(DEFAULT_DELIMITER);
    }

    private static void validate(final int[] numbers) {
        boolean negativeNumber = Arrays.stream(numbers)
                .anyMatch(NumberUtils::isLessThenZero);

        if (negativeNumber) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }
}