package calculator.split;

import calculator.common.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final Pattern pattern = Pattern.compile(Constants.CUSTOM_DELIMITER_REGEX);
    private final String text;

    public StringSplitter(String text) {
        this.text = text;
    }

    public String[] splitText() {
        if (useCustomDelimiter()) {
            return splitCustomDelimiter();
        }
        return text.split(Constants.DEFAULT_DELIMITER_REGEX);
    }

    private String[] splitCustomDelimiter() {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    private boolean useCustomDelimiter() {
        return text.matches(Constants.CUSTOM_DELIMITER_REGEX);
    }
}
