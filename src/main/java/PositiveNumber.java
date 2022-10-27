import java.util.Objects;

public final class PositiveNumber {

    public static final PositiveNumber ZERO = new PositiveNumber(0);

    private final int value;

    public PositiveNumber(final int value) {
        validateValue(value);
        this.value = value;
    }

    private static void validateValue(final int value) {
        if (value < 0) {
            throw new NumberFormatException("value can not be negative");
        }
    }

    public PositiveNumber plus(final PositiveNumber positiveNumber) {
        Objects.requireNonNull(positiveNumber);
        return new PositiveNumber(value + positiveNumber.value);
    }

    public int intValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}

