package calculator;

public class PositiveOperand {

    private final int operand;

    public PositiveOperand(String operand) {
        validate(operand);
        this.operand = Integer.parseInt(operand);
    }

    private void validate(String source) {
        validateNotNumeric(source);
        validateNegatives(source);
    }

    private void validateNotNumeric(String operand) {
        try {
            Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new RuntimeException("피연산자는 숫자 형태의 값을 입력해야 합니다. input :" + operand);
        }
    }

    private void validateNegatives(String operand) {

        int input = Integer.parseInt(operand);
        if (input < 0) {
            throw new RuntimeException("피연산자는 양수인 숫자여야 합니다. input:" + operand);
        }
    }

    public int getOperand() {
        return operand;
    }
}
