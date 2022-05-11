package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {

    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    static int calculate(String value) {
        if (isEmpty(value)) {
            return 0;
        }
        final String[] maybeNumbers = split(value);
        return sum(maybeNumbers);
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    private static String[] split(String value) {
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(value);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return DEFAULT_DELIMITER_PATTERN.split(value);
    }

    private static int sum(String[] maybeNumbers) {
        int total = 0;
        for (String maybeNumber : maybeNumbers) {
            total += parseUnsignedInt(maybeNumber);
        }
        return total;
    }

    private static int parseUnsignedInt(String maybeNumber) {
        int number = Integer.parseInt(maybeNumber);
        if (number < 0) {
            throw new NumberFormatException("음수가 될 수 없습니다");
        }
        return number;
    }
}
