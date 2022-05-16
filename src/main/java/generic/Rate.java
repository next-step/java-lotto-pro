package generic;

import java.util.Objects;

public class Rate {

    private final double value;

    private Rate(final double value) {
        this.value = value;
    }

    public static Rate valueOf(final double doubleValue) {
        return new Rate(doubleValue);
    }

    public double getValue() {
        return value;
    }

    public int getIntValue() {
        return Double.valueOf(value).intValue();
    }

    public String toStringValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rate)) {
            return false;
        }
        final Rate rate = (Rate) o;
        return Double.compare(rate.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "value=" + value +
                '}';
    }
}
