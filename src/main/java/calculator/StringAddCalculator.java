package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException ignored) {
        }
        return 0;
    }
}
