package utils;

public class StringAdderCalculator {

    public static int splitAndSum(String text) {
        if (isTextEmptyOrNull(text)) {
            return 0;
        }
        return 0;
    }

    private static boolean isTextEmptyOrNull(String strings) {
        return strings == null || strings.trim().isEmpty();
    }
}
