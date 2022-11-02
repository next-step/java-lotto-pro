package step4.util;

public final class StringUtil {
    private static final String BASE_DELIMITER = "\\s*,\\s*";

    private StringUtil() {
        throw new AssertionError(String.format("%s class can not be instantiated", getClass().getName()));
    }

    public static String[] parseLottoText(String text) {
        return text.split(BASE_DELIMITER);
    }
}