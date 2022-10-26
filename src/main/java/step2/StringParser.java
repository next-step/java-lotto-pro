package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String BASE_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public StringParser() {

    }

    public String[] parseText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASE_DELIMITER);
    }
}
