package stringaddcalculator;

public class PositiveInteger {
    public static final PositiveInteger ZERO = new PositiveInteger(0);
    private final int value;

    private PositiveInteger(final int value) {
        validatePositive(value);
        this.value = value;
    }

    public static PositiveInteger valueOf(final int value) {
        return new PositiveInteger(value);
    }

    public int getValue() {
        return value;
    }

    public PositiveInteger add(final PositiveInteger positiveInteger) {
        return new PositiveInteger(value + positiveInteger.getValue());
    }

    private void validatePositive(final int value) {
        if (isMinus(value)) {
            throw new IllegalArgumentException("음수는 입력 할 수 없습니다.");
        }
    }

    private boolean isMinus(final int value) {
        return value < 0;
    }
}
