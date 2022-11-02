package lotto.domain;

public class Yields {
    private final double value;

    public Yields(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
