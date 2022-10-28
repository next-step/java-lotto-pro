package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final String DEFAULT_REGEX = "[,:]";
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final Pattern pattern;

    static {
        pattern = Pattern.compile(CUSTOM_PATTERN);
    }

    private final String str;
    private final String delimiter;

    public Tokenizer(String str) {
        if (str == null) {
            str = "";
        }
        this.str = getStr(str);
        this.delimiter = getDelimiter(str);
    }

    private String getStr(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return str;
    }

    private String getDelimiter(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_REGEX;
    }


    public boolean isDelimiter(String delimiter) {
        return Objects.equals(this.delimiter, delimiter);
    }

    public String[] split() {
        return this.str.split(delimiter);
    }
}
