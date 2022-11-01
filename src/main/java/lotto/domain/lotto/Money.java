package lotto.domain.lotto;

import static lotto.utils.Validations.requireNotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(BigDecimal.ZERO);

    private final BigDecimal value;

    public Money(long value) {
        this(BigDecimal.valueOf(value));
    }

    public Money(BigDecimal value) {
        requireNotNull(value, "값이 null이 아니어야 합니다.");
        requirePositiveOrZero(value);

        this.value = value;
    }

    private static void requirePositiveOrZero(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("금액은 음수가 아니어야 합니다. value=[" + value + "]");
        }
    }

    public boolean isZero() {
        return BigDecimal.ZERO.equals(this.value);
    }

    public BigDecimal divide(final Money other) {
        return this.value.divide(other.value);
    }

    public Money multiply(long value) {
        return new Money(this.value.multiply(BigDecimal.valueOf(value)));
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
        return value.equals(money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
