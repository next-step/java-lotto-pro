package split;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern regex = Pattern.compile("//(.)\n(.*)");
    public static final int DEFAULT_VALUE = 0;
    private final String text;
    private final String delimiter;

    public StringCalculator(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    public String[] split() {
        if (Objects.isNull(text) || text.isEmpty()) {
            return new String[DEFAULT_VALUE];
        }
        Matcher m = regex.matcher(text);
        if (m.find()) {
            return m.group(2).split(this.delimiter);
        }
        return text.split(this.delimiter);
    }
}
