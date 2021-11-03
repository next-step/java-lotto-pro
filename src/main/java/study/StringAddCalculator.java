package study;

public class StringAddCalculator {

    public static int splitAndSum(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }
        return 0;
    }

    private static boolean isEmptyOrNull(final String text) {
        return text == null || text.isEmpty();
    }
}
