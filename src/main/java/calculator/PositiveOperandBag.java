package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class PositiveOperandBag {
    private List<PositiveOperand> operands;

    public PositiveOperandBag(List<String> operandWords) {
        this.operands = operandWords.stream()
                .map(PositiveOperand::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return operands.stream()
                .mapToInt(PositiveOperand::getOperand)
                .sum();
    }
}
