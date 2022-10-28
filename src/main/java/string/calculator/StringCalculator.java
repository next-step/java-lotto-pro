package string.calculator;

public class StringCalculator {
    private static final int DEFAULT_RESULT_ZERO = 0;
    private final String input;

    public StringCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (inputNullOrEmpty()) {
            return StringCalculator.DEFAULT_RESULT_ZERO;
        }
        final String[] tokens = splitInput();
        return 0;
    }

    private boolean inputNullOrEmpty() {
        return input == null || input.isEmpty();
    }

    private String[] splitInput() {
        final InputSplitter inputSplitter = new InputSplitter(input);
        return inputSplitter.split();
    }
}
