package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddParser {
    private static final Pattern CUSTOM_STRING_REGEXP = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_STRING_DELIMITER = "[,:]";
    private static final Pattern DEFAULT_STRING_REGEXP = Pattern.compile("[0-9"+DEFAULT_STRING_DELIMITER+"]+");
    private static final String INVALID_INPUT = "양수만 입력해주세요.";

    private StringAddParser() {
    }

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_STRING_REGEXP.matcher(input);
        if (matcher.matches()) {
            return splitCustomString(matcher);
        }

        validateDefaultString(input);

        return splitDefaultString(input);
    }

    private static void validateDefaultString(String input) {
        Matcher matcher = DEFAULT_STRING_REGEXP.matcher(input);
        if (!matcher.matches()) {
            throw new RuntimeException(INVALID_INPUT);
        }
    }

    private static String[] splitDefaultString(String input) {
        return input.split(DEFAULT_STRING_DELIMITER);
    }

    private static String[] splitCustomString(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }
}
