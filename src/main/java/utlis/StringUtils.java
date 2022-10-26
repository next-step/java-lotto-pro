package utlis;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

}
