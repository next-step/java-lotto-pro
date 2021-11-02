package calculator;

public class TextSplit {
    private static final String DELIMITER = "[,:]";

    public static String[] split(String text) {
        return text.split(DELIMITER);
    }
}
