package calculator;

public class StringSplitter {
    private static final String DEFAULT_DELIMETER = ",|:";

    public static String[] split(String input) {
        return input.split(DEFAULT_DELIMETER);
    }
}
