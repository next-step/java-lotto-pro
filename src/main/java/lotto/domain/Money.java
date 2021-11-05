package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    private Money(long amount) {
        this(BigDecimal.valueOf(amount));
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    public static Money of(String text) {
        return new Money(new BigDecimal(text));
    }

    public long longValue() {
        return this.amount.longValue();
    }

    public Money divide(Money money) {
        return Money.of(amount.divide(money.amount, 2, RoundingMode.HALF_DOWN));
    }

    public Money minus(Money money) {
        return Money.of(amount.subtract(money.amount));
    }

    public double doubleValue() {
        return amount.doubleValue();
    }

    public int intValue() {
        return amount.intValue();
    }

    public boolean isLessThan(Money money) {
        return this.amount.compareTo(money.amount) < 0;
    }

    public boolean isModResultZero(Money money) {
        return amount.remainder(money.amount).compareTo(BigDecimal.ZERO) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
