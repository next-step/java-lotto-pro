package study;

public class StringUtil {

    public static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int[] convertStringArrayToIntArray(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
            StringAddCalculator.checkNegativeNumber(numbers[i]);
        }
        return numbers;
    }

    public static String[] splitText(String text, String delimiter) {
        return text.split(delimiter);
    }
}
