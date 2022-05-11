package study;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;

    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return DEFAULT_NUMBER;
        }
        return Integer.parseInt(str);
    }
}
