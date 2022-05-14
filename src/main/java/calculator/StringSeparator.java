package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private static final String BASIC_SPLIT = ",|:";
    private static final Pattern CUSTOM_SPLIT = Pattern.compile("//(.)\n(.*)");

    private StringSeparator() {
    }

    public static Numbers split(String input) {
        Matcher custom = CUSTOM_SPLIT.matcher(input);
        if (custom.find()) {
            return makeNumbers(custom.group(2).split(custom.group(1)));
        }

        return makeNumbers(input.split(BASIC_SPLIT));
    }

    private static Numbers makeNumbers(String[] integers) {
        Numbers numbers = new Numbers();
        for (String integer : integers) {
            numbers.add(new Number(integer));
        }
        return numbers;
    }
}
