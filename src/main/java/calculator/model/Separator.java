package calculator.model;

import exception.IllegalArgument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private String delimiter;
    private String text;
    private static final String commaOrColonDelimiter = "[,:]";

    Separator(StringPattern pattern, String text) throws RuntimeException {
        if (pattern == StringPattern.FIXED) {
            initFixedPattern(text);
        }

        if (pattern == StringPattern.CUSTOM) {
            initCustomPattern(text);
        }

        if (pattern == StringPattern.NOTHING) {
            throw IllegalArgument.NEGATIVE_OR_NOT_NUMBER;
        }
    }

    private void initFixedPattern(String text) {
        this.delimiter = commaOrColonDelimiter;
        this.text = text;
    }

    private void initCustomPattern(String text) {
        Matcher customPatternMatcher = Pattern.compile(StringPattern.CUSTOM.pattern()).matcher(text);
        customPatternMatcher.find();
        this.delimiter = customPatternMatcher.group(1);
        this.text = customPatternMatcher.group(2);
    }

    public String[] separate(){
        return text.split(delimiter);
    }
}
