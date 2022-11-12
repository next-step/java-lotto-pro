package play.util;

public class SplitUtils {
    private final static String SEPARATOR = ",";

    public static String[] splitInputNumbers(String input) {
        return input.trim().split(SEPARATOR);
    }
}
