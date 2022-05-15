package calculator;

public class StringUtils {
    private static final String EMPTY = "";

    public static boolean isEmpty(final String word) {
        return word == null || EMPTY.equals(word);
    }

}
