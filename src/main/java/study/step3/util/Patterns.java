package study.step3.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Patterns {
    ONLY_NUMBERS("^[0-9]*$");

    private final Pattern pattern;

    Patterns(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean match(String value) {
        Matcher matcher = this.pattern.matcher(value);
        return matcher.find();
    }
}
