package string;

public class StringAddCalculator {
    private static final int RESULT_WHEN_INPUT_IS_EMPTY = 0;

    public static int splitAndSum(String text) {
        Input input = new Input(text);

        if (input.isEmpty()) {
            return RESULT_WHEN_INPUT_IS_EMPTY;
        }

        Numbers numbers = input.split();
        return numbers.sum();
    }
}
