package stringaddcalculator;

public class StringAddCalculator {

    public static int splitAndSum(String inputText) {
        if (isNullOrEmpty(inputText)) {
            return 0;
        }
        return Integer.parseInt(inputText);
    }

    private static boolean isNullOrEmpty(String inputText) {
        if (inputText == null) {
            return true;
        }
        if (inputText.isEmpty()) {
            return true;
        }
        return false;
    }
}
