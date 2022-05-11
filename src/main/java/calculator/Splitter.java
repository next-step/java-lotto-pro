package calculator;

import java.util.regex.Pattern;

public class Splitter {

    public static final Pattern DEFAULT_PATTERN = Pattern.compile("[,:]");

    public static Numbers split(String input) {
        return new Numbers(DEFAULT_PATTERN.split(input));
    }
}
