package lotto.domain;

import java.util.Objects;

public class Money {
    private static final String DEFAULT_UNIT = "원";
    private final int value;
    private final String unit;

    private Money(int value) {
        this.value = value;
        this.unit = DEFAULT_UNIT;
        validate();
    }

    public static Money from(int value) {
        return new Money(value);
    }

    public int divide(Money target) {
        return this.value / target.value;
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
}
