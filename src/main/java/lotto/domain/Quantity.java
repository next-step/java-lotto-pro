package lotto.domain;

public class Quantity {
    private static final int ZERO = 0;

    private final int value;

    public Quantity(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("수량은 0보다 작을 수 없습니다.");
        }
    }

    public int value() {
        return this.value;
    }
}
