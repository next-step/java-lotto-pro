package stringadder;

import java.util.Objects;

public class PositiveInt {
    public static final PositiveInt ZERO = new PositiveInt(0);
    private final int value;

    public PositiveInt(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수가 아니어야 합니다. value=[" + value + "]");
        }

        this.value = value;
    }

    public static PositiveInt parse(String value) {
        return new PositiveInt(Integer.parseInt(value));
    }

    public PositiveInt plus(final PositiveInt other) {
        return new PositiveInt(this.value + other.value);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveInt that = (PositiveInt) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
