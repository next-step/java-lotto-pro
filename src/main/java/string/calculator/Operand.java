package string.calculator;

public class Operand {
    private final int value;

    public Operand(int value) {
        if (isNegative(value)) {
            throw new RuntimeException("음수값을 사용할 수 없습니다.");
        }

        this.value = value;
    }

    private boolean isNegative(int value) {
        return value < 0;
    }
}
