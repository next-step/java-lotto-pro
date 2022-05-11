package calculator.model;

import java.util.Arrays;
import java.util.Optional;

public enum StringPattern {
    FIXED("(\\d+(,|:)?)+"),
    CUSTOM("//(.)\n(.*)"),
    NOTHING("$^");

    private final String patternValue;

    StringPattern(String patternValue) {
        this.patternValue = patternValue;
    }

    public String pattern() {
        return patternValue;
    }

    public static StringPattern determine(String text) {
        Optional<StringPattern> findPattern = Arrays.stream(StringPattern.values()).filter(p -> text.matches(p.pattern())).findAny();
        return findPattern.orElse(StringPattern.NOTHING);
    }
}
