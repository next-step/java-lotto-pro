package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        int sum = 0;
        if (isEmpty(text)) {
            return Constants.EMPTY_RETURN;
        }
        return sum;
    }

    private static boolean isEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
