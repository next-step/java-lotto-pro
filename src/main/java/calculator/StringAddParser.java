package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class StringAddParser {
    private static final Pattern CUSTOM_STRING_REGEXP = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_STRING_DELIMITER = "[,:]";
    private static final Pattern DEFAULT_STRING_REGEXP = Pattern.compile("[0-9"+DEFAULT_STRING_DELIMITER+"]+");
    private static final String INVALID_INPUT = "양수만 입력해주세요.";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_STRING_GROUP = 2;

    private StringAddParser() {
    }

    public static List<Integer> split(String input) {
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

    private static List<Integer> splitDefaultString(String input) {
        return convertSplitString(input.split(DEFAULT_STRING_DELIMITER));
    }

    private static List<Integer> splitCustomString(Matcher matcher) {
        String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
        String stringNumbers = matcher.group(CUSTOM_STRING_GROUP);
        return convertSplitString(stringNumbers.split(customDelimiter));
    }

    private static List<Integer> convertSplitString(String[] stringNumbers) {
        return stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }
}
