package step2;

public class StringAddCalculator {

    public static int splitAndSum(String inputString) {
        if (isEmptyString(inputString)) {
            return 0;
        }
        if (isSingleNumber(inputString)) {
            return Integer.parseInt(inputString);
        }
        return -1;
    }

    private static boolean isEmptyString(String source) {
        return source == null || source.isEmpty();
    }

    private static boolean isSingleNumber(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
