package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimitedString {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile(DEFAULT_DELIMITERS);
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    private final Pattern delimiter;
    private final String body;

    public DelimitedString(Pattern delimiter, String body) {
        this.delimiter = delimiter;
        this.body = body;
    }

    public DelimitedString(String body) {
        this(DEFAULT_DELIMITER_PATTERN, body);
    }

    public static DelimitedString delimit(String text) {
        Matcher matcher = matchPattern(text);
        if (!matcher.find()) {
            return new DelimitedString(text);
        }
        String delimiter = matcher.group(1);
        String body = matcher.group(2);

        return new DelimitedString(Pattern.compile(delimiter), body);
    }

    private static Matcher matchPattern(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text);
    }

    public SplitStrings split() {
        return new SplitStrings(delimiter.split(body));
    }
}