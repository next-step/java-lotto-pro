package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String BASIC_DELIMITER = ",|:";

    private final String[] splitString;

    public SplitString(String stringValue) {
        splitString = init(stringValue);
    }

    public String[] getSplitString() {
        return splitString;
    }

    private String[] init(String stringValue) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(stringValue);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return stringValue.split(BASIC_DELIMITER);
    }
}
