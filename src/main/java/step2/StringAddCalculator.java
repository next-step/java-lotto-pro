package step2;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null) return 0;
        if (text.isEmpty()) return 0;
        if (isNumber(text)) return convertNumber(text);
        return 0;
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int convertNumber(String text) {
        return Integer.parseInt(text);
    }
}
