package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (isValidationCheckNullOrEmpty(text)) {
            return 0;
        }

        return Integer.parseInt(text);
    }

    private static boolean isValidationCheckNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
