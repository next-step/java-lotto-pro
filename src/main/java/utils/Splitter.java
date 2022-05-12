package utils;

public class Splitter {
    private final static String DEFAULT_DELIMITERS = ",|:";

    public static String[] split(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }
}
