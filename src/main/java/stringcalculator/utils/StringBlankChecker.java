package stringcalculator.utils;

public class StringBlankChecker {

    private StringBlankChecker() {
    }

    public static boolean isBlank(String input) {
        return isNull(input) || input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }

}
