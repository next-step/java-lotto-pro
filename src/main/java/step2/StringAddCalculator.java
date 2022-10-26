package step2;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (validateBlank(text)) {
            return 0;
        }
        return 1;
    }

    private static boolean validateBlank(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }
}
