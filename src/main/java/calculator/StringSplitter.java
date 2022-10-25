package calculator;

public class StringSplitter {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private StringSplitter() {
        throw new IllegalStateException("Utility class");
    }

    public static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
