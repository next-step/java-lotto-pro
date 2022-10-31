package calculator;

import java.util.Objects;

public class TextExtractor {

    public static final String DEFAULT_VALUE = "0";

    private final String text;

    public TextExtractor(String text) {
        this.text = text;
    }

    public String extract() {
        if (Objects.isNull(text) || text.isEmpty()) {
            return DEFAULT_VALUE;
        }
        return "";
    }
}
