package calculator;

public class Operand {

    private final int source;

    public Operand(String source) {
        validate(source);
        this.source = Integer.parseInt(source);
    }

    private void validate(String source) {
        validateNotNumeric(source);
        validateNegatives(source);
    }

    private void validateNotNumeric(String source) {
        try {
            Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new RuntimeException("피연산자는 숫자 형태의 값을 입력해야 합니다. input :" + source);
        }
    }

    private void validateNegatives(String source) {

        int input = Integer.parseInt(source);
        if (input < 0) {
            throw new RuntimeException("피연산자는 양수인 숫자여야 합니다. input:" + source);
        }
    }

    public int getSource() {
        return source;
    }
}
