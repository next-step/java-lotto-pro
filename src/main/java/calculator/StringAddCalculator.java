package calculator;

public class StringAddCalculator {
    public static int splitSum(String str) {
        if(isNull(str)) {
            return 0;
        }
        if(isEmpty(str)) {
            return 0;
        }
        return 1;
    }

    private static boolean isNull(String str) {
        return str == null;
    }

    private static boolean isEmpty(String str) {
        return str.isEmpty();
    }
}
