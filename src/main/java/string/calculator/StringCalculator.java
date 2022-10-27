package string.calculator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class StringCalculator {
    private final String input;

    public StringCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (isEmpty(input)) {
            return 0;
        }
        final String[] tokens = splitInput();
        return 0;
    }

    private String[] splitInput() {
        final InputSplitter inputSplitter = new InputSplitter(input);
        return inputSplitter.split();
    }
}
