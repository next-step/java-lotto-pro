package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    private StringAddCalculator() {
        throw new UnsupportedOperationException();
    }

    protected static List<String> splitString(String input) {
        if (isNullOrEmpty(input)) {
            return Collections.emptyList();
        }

        Matcher matcher = generateCustomMatcher(input);

        if (matcher.find()) {
            return splitStringWithCustomDelimiter(matcher);
        }

        return splitStringWithDelimiter(input);
    }

    protected static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static Matcher generateCustomMatcher(String input) {
        return CUSTOM_PATTERN.matcher(input);
    }

    private static ArrayList<String> splitStringWithCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);

        return stringArrayToList(tokens);
    }

    private static List<String> splitStringWithDelimiter(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITER);

        return stringArrayToList(tokens);
    }

    private static ArrayList<String> stringArrayToList(String[] tokens) {
        return new ArrayList<>(Arrays.asList(tokens));
    }
}
