package string_add_calculator.util;

public class StringAddCalculatorUtil {

    private static final char MIN_INT_VALUE = 48;
    private static final char MAX_INT_VALUE = 59;

    public static int toInt(String number) {
         char[] arr = number.toCharArray();
         for(char ch : arr) {
            charIntValueCheck(ch);
         }
         return Integer.parseInt(number);
    }

    public static void charIntValueCheck(char ch) {
        if(!isCharIntValue(ch)) throw new RuntimeException();
    }

    public static boolean isCharIntValue(char ch) {
        return ch >= MIN_INT_VALUE && ch <= MAX_INT_VALUE;
    }
}
