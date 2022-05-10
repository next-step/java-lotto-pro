package step2;

public class StringAddCalculator {

    public static int splitAndSum(String inputString) {
        if (isEmptyString(inputString)) {
            return 0;
        }
        return -1;
    }

    private static boolean isEmptyString(String source) {
        return source == null || source.isEmpty();
    }
}
