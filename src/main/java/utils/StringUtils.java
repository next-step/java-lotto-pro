package utils;

public class StringUtils {

    public static final String DELIMITER = ",";

    public static String[] split(String text) {
        return text.split(DELIMITER);
    }
}
