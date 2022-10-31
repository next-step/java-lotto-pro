package lotto.domain.lotto;

import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(0);

    private final long value;

    public Money(long value) {
        if (value < 0L) {
            throw new IllegalArgumentException("금액은 음수가 아니어야 합니다. value=[" + value + "]");
        }

        this.value = value;
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public int divide(final Money other) {
        return Math.toIntExact(this.value / other.value);
    }

    public Money multiply(long value) {
        return new Money(this.value * value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
