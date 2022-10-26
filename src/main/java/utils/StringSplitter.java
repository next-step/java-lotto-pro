package utils;

import java.util.Objects;

public class StringSplitter {
    public static SplitStrings split(String text) {
        if (isTextNullOrEmpty(text)) {
            return SplitStrings.EMPTY;
        }
        DelimitedString delimitedString = DelimitedString.delimit(text);

        return delimitedString.split();
    }

    private static boolean isTextNullOrEmpty(String text) {
        return Objects.isNull(text) || text.trim().isEmpty();
    }

}
