package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextExtractor {

    public static final String DEFAULT_VALUE = "0";
    public static final int TEXT_PART = 2;
    public static final int DELIMITER_PART = 1;
    private static final Pattern regex = Pattern.compile("//(.)\n(.*)");
    private final String text;

    public TextExtractor(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            this.text = DEFAULT_VALUE;
            return;
        }
        this.text = text;
    }

    public String extract() {
        Matcher m = regex.matcher(this.text);
        if (m.find()) {
            return m.group(TEXT_PART);
        }
        return this.text;
    }

    public boolean hasDelimiter() {
        Matcher m = regex.matcher(this.text);
        return m.find();
    }

    public String delimiter() {
        Matcher m = regex.matcher(this.text);
        if (m.find()) {
            return m.group(DELIMITER_PART);
        }
        throw new IllegalArgumentException("구분자가 없습니다.");
    }
}
