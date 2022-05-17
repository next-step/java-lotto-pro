package lotto.domain;

import calculator.domain.StringSplitter;
import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private static final BigDecimal MIN_VALUE = BigDecimal.ZERO;

    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
        validate();
    }

    public static Money from(double value) {
        return new Money(new BigDecimal(Double.toString(value)));
    }

    public static Money from(String value) {
        return new Money(new BigDecimal(value));
    }

    public static Money from(BigDecimal value) {
        return new Money(value);
    }

    public BigDecimal divide(Money target) {
        return this.value.divide(target.value);
    }

    public Money add(Money target) {
        return Money.from(this.value.add(target.value));
    }

    private void validate() {
        if (this.value.compareTo(MIN_VALUE) == -1) {
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
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("%d", value.intValue());
    }
}
