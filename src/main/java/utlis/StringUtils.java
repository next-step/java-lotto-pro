package utlis;

public class StringUtils {

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static int toInt(String text) {
        return Integer.parseInt(text);
    }

}
