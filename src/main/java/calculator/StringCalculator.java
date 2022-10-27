package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private List<Operand> operands;
    private static final int NOT_CALCULATED = 0;

    private final Separator separator = new Separator();

    public int calculate(String input) {
        if (isNotCalculated(input)) {
            return NOT_CALCULATED;
        }
        List<String> operandWords = separator.separate(input);
        makeOperands(operandWords);
        return sum();
    }

    private boolean isNotCalculated(String input) {
        return input == null || input.trim().equals("");
    }

    private void makeOperands(List<String> operandWords) {
        operands = operandWords.stream()
                .map(Operand::new)
                .collect(Collectors.toList());
    }

    private int sum() {
        return operands.stream()
                .mapToInt(Operand::getSource)
                .sum();
    }
}
