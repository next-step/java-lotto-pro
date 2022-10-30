package calculator;

import java.util.List;

public class PositiveOperandBag {

    private PositiveOperandBag() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static int sum(List<String> operandWords) {
        return operandWords.stream()
                .map(PositiveOperand::new)
                .mapToInt(PositiveOperand::getOperand)
                .sum();
    }
}
