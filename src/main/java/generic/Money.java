package generic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private BigDecimal value;

    private Money(final BigDecimal value) {
        this.value = value;
    }

    public static Money wons(final int wons) {
        return new Money(BigDecimal.valueOf(wons));
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money plus(final Money money) {
        return new Money(value.add(money.getValue()));
    }

    public Money minus(final Money money) {
        return new Money(value.subtract(money.getValue()));
    }

    public Money times(final int times) {
        return new Money(value.multiply(BigDecimal.valueOf(times)));
    }

    public Money divide(final int divide) {
        return new Money(value.divide(BigDecimal.valueOf(divide), 0, RoundingMode.DOWN));
    }

    public int count(final Money divide) {
        return value.divide(divide.getValue(), 0, RoundingMode.DOWN)
                .intValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        final Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
