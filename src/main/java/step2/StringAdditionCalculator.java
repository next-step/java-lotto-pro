package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int addAllDelimiterString(final String numberWithDelimiter) {
        if (numberWithDelimiter == null) {
            return 0;
        }
        if (numberWithDelimiter.equals("")) {
            return 0;
        }
        if (hasCustomDelimiter(numberWithDelimiter)) {
            return addAllCustomDelimiterString(numberWithDelimiter);
        }
        return splitAndAddAllString(DEFAULT_DELIMITER, numberWithDelimiter);
    }

    private static boolean hasCustomDelimiter(final String numberWithDelimiter) {
        return Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(numberWithDelimiter).matches();
    }

    private static int addAllCustomDelimiterString(final String numberWithCustomDelimiter) {
        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(numberWithCustomDelimiter);
        if (matcher.find()) {
            final String delimiter = matcher.group(1);
            final String numberWithDelimiter = matcher.group(2);
            return splitAndAddAllString(delimiter, numberWithDelimiter);
        }
        throw new RuntimeException("there is no matched pattern.");
    }

    private static int splitAndAddAllString(final String delimiter, final String numberWithDelimiter) {
        final String[] numbers = numberWithDelimiter.split(delimiter);
        int sum = 0;
        for (final String number : numbers) {
            final int parsedNumber = parseStringToInt(number);
            checkNumberIsMinus(parsedNumber);
            sum += parsedNumber;
        }
        return sum;
    }

    private static void checkNumberIsMinus(final int parsedNumber) {
        if (parsedNumber < 0) {
            throw new RuntimeException("cannot enter minus number.");
        }
    }

    private static int parseStringToInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("cannot enter not a number.");
        }
    }
}
