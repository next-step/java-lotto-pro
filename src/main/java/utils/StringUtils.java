package utils;

public class StringUtils {

    public static final String DELIMITER = ",";

    public static String[] split(String text) {
        return text.split(DELIMITER);
    }

    public static String substring(String text, int startIndex, int endIndex) {
        return text.substring(startIndex, endIndex);
    }
}
