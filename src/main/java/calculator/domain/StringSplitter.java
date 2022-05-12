package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_INPUT_INDEX = 2;

    private String delimiter;
    private Pattern customDelimiterPattern;

    public StringSplitter(String delimiter, Pattern pattern) {
        this.delimiter = delimiter;
        this.customDelimiterPattern = pattern;
    }

    public String[] split(String input) {
        Matcher matcher = this.matcher(input);
        if (isCustomSplitPattern(matcher)) {
            return splitByPattern(matcher);
        }
        return splitByDelimiter(input);
    }

    private String[] splitByDelimiter(String input) {
        return input.split(delimiter);
    }

    private String[] splitByPattern(Matcher matcher) {
        String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
        return matcher.group(CUSTOM_INPUT_INDEX).split(customDelimiter);
    }

    private Matcher matcher(String input) {
        return customDelimiterPattern.matcher(input);
    }

    private boolean isCustomSplitPattern(Matcher matcher) {
        return matcher.find();
    }
}
