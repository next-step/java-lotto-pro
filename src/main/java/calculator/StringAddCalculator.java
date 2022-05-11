package calculator;

public class StringAddCalculator {

    public static final int ZERO = 0;

    public static int add(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }

        return 1;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
