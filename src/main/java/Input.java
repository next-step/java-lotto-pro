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
        removeCustomDelimiter();
        return new Numbers(value.split(delimiter));
    }

    private String getDelimiter() {
        final int DELIMITER_GROUP_NO = 1;
        Matcher m = getCustomDelimiterMatcher();
        if (m.find()) {
            return m.group(DELIMITER_GROUP_NO);
        }
        return DEFAULT_DELIMITER;
    }

    private void removeCustomDelimiter() {
        final int VALUE_GROUP_NO = 2;
        Matcher m = getCustomDelimiterMatcher();
        if (m.find()) {
            value = m.group(VALUE_GROUP_NO);
        }
    }

    private Matcher getCustomDelimiterMatcher() {
        return Pattern.compile("//(.)\n(.*)").matcher(value);
    }
}
