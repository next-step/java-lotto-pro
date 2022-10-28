package string.calculator;

public class StringCalculator {
    private final String input;

    public StringCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (inputNullOrEmpty()) {
            return 0;
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
