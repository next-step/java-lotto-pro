package lotto.domain;

import java.util.Objects;

public class Money {
    private final int value;

    public Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("금액은 음수가 아니어야 합니다. value=[" + value + "]");
        }

        this.value = value;
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public int divide(final Money other) {
        return this.value / other.value;
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
