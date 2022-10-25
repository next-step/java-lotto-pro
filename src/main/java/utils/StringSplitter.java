package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static List<String> split(String text) {
        if (isTextNullOrEmpty(text)) {
            return Collections.emptyList();
        }
        if (isDefaultDelimiter(text)) {
            return split(text, DEFAULT_DELIMITERS);
        }
        return splitAndSumWithCustomDelimiter(text);
    }

    private static boolean isTextNullOrEmpty(String text) {
        return Objects.isNull(text) || text.trim().isEmpty();
    }

    private static List<String> splitAndSumWithCustomDelimiter(String text) {
        Matcher matchers = matchPattern(text);
        if (!matchers.find()) {
            throw new IllegalArgumentException("Not found Custom Delimiters");
        }
        String customDelimiter = matchers.group(1);
        String numbersLiteral = matchers.group(2);

        return split(numbersLiteral, customDelimiter);
    }

    private static Matcher matchPattern(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text);
    }

    private static boolean isDefaultDelimiter(String text) {
        return !matchPattern(text).matches();
    }

    private static List<String> split(String text, String delimiters) {
        return toList(text.split(delimiters));
    }

    private static List<String> toList(String[] split) {
        return Arrays.stream(split).collect(Collectors.toList());
    }
}
