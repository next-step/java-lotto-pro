package calculator;

public class StringAddCalculator {

    public static final int ZERO = 0;

    public static int add(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }
        Numbers numbers = Splitter.split(input);

        return numbers.sum();
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
