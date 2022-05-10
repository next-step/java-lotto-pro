package stringaddcalculator;

public class StringAddCalculator {
    public static int splitAndSum(final String text) {
        if (validateNullOrEmpty(text)) {
            return 0;
        }

        return Integer.parseInt(text);
    }

    private static boolean validateNullOrEmpty(final String text) {
        if (text == null) {
            return true;
        }
        return text.isEmpty();
    }

}
