package lotto.domain;

import calculator.domain.StringSplitter;
import java.util.Objects;

public class Money {
    private static final String DEFAULT_UNIT = "원";
    private final double value;
    private final String unit;

    private Money(double value) {
        this.value = value;
        this.unit = DEFAULT_UNIT;
        validate();
    }

    public static Money from(double value) {
        return new Money(value);
    }

    public static Money from(String value) {
        return new Money(Double.parseDouble(value));
    }

    public double divide(Money target) {
        return this.value / target.value;
    }

    public Money add(Money target) {
        return Money.from(this.value + target.value);
    }

    private void validate() {
        if (this.value < 0) {
            throw new IllegalArgumentException("돈은 음수 일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money that = (Money) o;
        return value == that.value && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return String.format("%d", (int) value) + unit;
    }
}
