import java.util.Objects;

public class Number {
    final int value;

    public Number(String value) {
        this.value = Integer.parseInt(value);
        if (this.value < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
