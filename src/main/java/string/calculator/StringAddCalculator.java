package string.calculator;

public class StringAddCalculator {
    private static final int DEFAULT_RESULT_ZERO = 0;
    private final String input;

    public StringAddCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (inputNullOrEmpty()) {
            return StringAddCalculator.DEFAULT_RESULT_ZERO;
        }
        final String[] tokens = splitInput();
        final Operand[] operands = convertToOperand(tokens);
        return calculateOperands(operands);
    }

    private boolean inputNullOrEmpty() {
        return input == null || input.isEmpty();
    }

    private String[] splitInput() {
        final InputSplitter inputSplitter = new InputSplitter(input);
        return inputSplitter.split();
    }

    private Operand[] convertToOperand(String[] tokens) {
        final Operand[] operands = new Operand[tokens.length];
        for (int i = 0; i < operands.length; ++i) {
            operands[i] = new Operand(tokens[i]);
        }
        return operands;
    }

    private int calculateOperands(Operand[] operands) {
        final SumOfOperands sumOfOperands = new SumOfOperands(operands);
        return sumOfOperands.result();
    }
}
