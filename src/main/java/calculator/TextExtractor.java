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
    private Delimiters delimiters;

    public TextExtractor(Delimiters delimiters, String text) {
        this.delimiters = delimiters;
        if (Objects.isNull(text) || text.isEmpty()) {
            this.text = DEFAULT_VALUE;
            return;
        }
        addCustomDelimiter(delimiters, text);
        this.text = extractText(text);
    }

    private void addCustomDelimiter(Delimiters delimiters, String text) {
        if (hasDelimiter(text)) {
            delimiters.add(customDelimiter(text));
        }
    }

    public String[] extract() {
        return this.text.split(this.delimiters.delimiter());
    }

    public String extractText(String text) {
        Matcher m = regex.matcher(text);
        if (m.find()) {
            return m.group(TEXT_PART);
        }
        return text;
    }

    public boolean hasDelimiter(String text) {
        return regex.matcher(text).find();
    }

    public String customDelimiter(String text) {
        Matcher m = regex.matcher(text);
        if (m.find()) {
            return m.group(DELIMITER_PART);
        }
        throw new IllegalArgumentException("구분자가 없습니다.");
    }
}
