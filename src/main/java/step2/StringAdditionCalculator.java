package step2;

import java.util.regex.Matcher;

public class StringAdditionCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int NULL_OR_EMPTY_STRING_RESULT = 0;
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int NUMBER_WITH_DELIMITER_INDEX = 2;

    public static int addAllDelimiterString(final String numberWithDelimiter) {
        if (StringValidator.isNullOrEmptyString(numberWithDelimiter)) {
            return NULL_OR_EMPTY_STRING_RESULT;
        }
        if (PatternValidator.hasCustomDelimiter(numberWithDelimiter)) {
            return addAllCustomDelimiterString(numberWithDelimiter);
        }
        return splitAndAddAllString(DEFAULT_DELIMITER, numberWithDelimiter);
    }

    private static int addAllCustomDelimiterString(final String numberWithCustomDelimiter) {
        final Matcher matcher = PatternValidator.matcher(numberWithCustomDelimiter);
        if (matcher.find()) {
            final String delimiter = matcher.group(DELIMITER_GROUP_INDEX);
            final String numberWithDelimiter = matcher.group(NUMBER_WITH_DELIMITER_INDEX);
            return splitAndAddAllString(delimiter, numberWithDelimiter);
        }
        throw new RuntimeException("there is no matched pattern.");
    }

    private static int splitAndAddAllString(final String delimiter, final String numberWithDelimiter) {
        final String[] stringNumbers = StringSplitter.split(delimiter, numberWithDelimiter);
        return new Numbers(stringNumbers).total();
    }
}
