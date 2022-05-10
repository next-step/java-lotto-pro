package calculator.utils;

public class StringUtils {

    private StringUtils(){
        throw new AssertionError();
    }

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
}
