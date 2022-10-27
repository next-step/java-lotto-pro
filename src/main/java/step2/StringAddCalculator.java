package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int NUMBER_OF_DELIMITER_GROUP = 1;
    private static final int NUMBER_OF_TEXT_GROUP = 2;
    private static final String ERR_CAN_NOT_CONVERT_NEGATIVE_NUMBER_TO_INT = "Can not Convert NegativeNumber To Int";
    private static final String ERR_IS_NOT_A_INTEGER_FORMAT = "Is Not a Integer Format";

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return ZERO;
        }
        String[] numbersAsString = split(text);
        return sum(numbersAsString);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(NUMBER_OF_TEXT_GROUP).split(matcher.group(NUMBER_OF_DELIMITER_GROUP));
        }
        return DEFAULT_DELIMITER_PATTERN.split(text);
    }

    private static int sum(String[] numbersAsString) {
        return Arrays.stream(numbersAsString)
                .mapToInt(StringAddCalculator::getNumber)
                .sum();
    }

    private static int getNumber(String text) {
        int number = convertToNumber(text);
        validateNumberIsNotNegative(number);
        return number;
    }

    private static void validateNumberIsNotNegative(int number) {
        if (number < ZERO) {
            throw new RuntimeException(ERR_CAN_NOT_CONVERT_NEGATIVE_NUMBER_TO_INT);
        }
    }

    private static int convertToNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new RuntimeException(ERR_IS_NOT_A_INTEGER_FORMAT, exception);
        }
    }
}
