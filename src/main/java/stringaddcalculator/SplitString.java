package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String BASIC_DELIMITER = ",|:";
    public static final int STRING_WITHOUT_DELIMITER_GROUP_VALUE = 2;
    public static final int DELIMITER_GROUP_VALUE = 1;

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
            return matcher.group(STRING_WITHOUT_DELIMITER_GROUP_VALUE).split(matcher.group(DELIMITER_GROUP_VALUE));
        }
        return stringValue.split(BASIC_DELIMITER);
    }
}
