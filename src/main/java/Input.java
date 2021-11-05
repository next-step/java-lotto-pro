import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private final static String DEFAULT_DELIMITER = ",|:";

    private String value;

    public Input(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == null || value.isEmpty();
    }

    public Numbers split() {
        String delimiter = getDelimiter();
        sanitizeValue();
        return new Numbers(value.split(delimiter));
    }

    private String getDelimiter() {
        Matcher m = getCustomDelimiterMatcher();
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private void sanitizeValue() {
        Matcher m = getCustomDelimiterMatcher();
        if (m.find()) {
            value = m.group(2);
        }
    }

    private Matcher getCustomDelimiterMatcher() {
        return Pattern.compile("//(.)\n(.*)").matcher(value);
    }
}
