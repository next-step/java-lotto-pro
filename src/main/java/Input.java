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
        String delimiter = getDelimiterAndSanitizeValue();
        return new Numbers(value.split(delimiter));
    }

    private String getDelimiterAndSanitizeValue() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            value = m.group(2);
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

}
