package step3.util;

public final class StringUtil {
    private static final String BASE_DELIMITER = "\\s*,\\s*";

    public StringUtil() {

    }

    public static String[] parseLottoText(String text) {
        return text.split(BASE_DELIMITER);
    }
}