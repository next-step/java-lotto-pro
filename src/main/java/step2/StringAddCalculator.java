package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {

    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        final String[] maybeNumbers;
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            maybeNumbers = matcher.group(2).split(customDelimiter);
        } else {
            maybeNumbers = DEFAULT_DELIMITER_PATTERN.split(value);
        }

        int total = 0;
        for (String maybeNumber : maybeNumbers) {
            int number = Integer.parseInt(maybeNumber);
            if (number < 0) {
                throw new RuntimeException("음수는 가질 수 없습니다.");
            }
            total += number;
        }
        return total;
    }
}
