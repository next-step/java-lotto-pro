package study;

public class StringUtil {

    private StringUtil() {
        throw new UnsupportedOperationException();
    }

    public static boolean isNullOrEmpty(String text) {
        return isNull(text) || isEmpty(text);
    }

    public static boolean isNull(String text) {
        return text == null;
    }

    public static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    public static int[] convertStringArrayToIntArray(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }

    public static String[] splitText(String text, String delimiter) {
        return text.split(delimiter);
    }
}
