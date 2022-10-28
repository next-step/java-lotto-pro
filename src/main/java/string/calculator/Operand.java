package string.calculator;

import java.util.Objects;

public class Operand {
    private final int value;

    public Operand(String token) {
        final int value = Integer.parseInt(token);

        if (isNegative(value)) {
            throw new RuntimeException("음수값을 사용할 수 없습니다.");
        }

        this.value = value;
    }

    private boolean isNegative(int value) {
        return value < 0;
    }

    public Operand add(Operand other) {
        int addResult = value + other.value;
        return new Operand(Integer.toString(addResult));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
