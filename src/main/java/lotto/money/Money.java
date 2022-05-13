package lotto.money;

import lotto.Purchasable;
import lotto.util.StringUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money implements Comparable<Money> {

    public static final Money ONE_THOUSAND = of(1000);

    private final long value;

    protected Money(String value) {
        this(parse(value));
    }

    protected Money(long value) {
        this.value = validated(value);
    }

    public static Money of(String value) {
        return new Money(value);
    }

    public static Money of(long value) {
        return new Money(value);
    }

    public boolean canPurchase(Purchasable purchasable) {
        if (purchasable == null) {
            return false;
        }
        final Money money = purchasable.price();
        return compareTo(money) >= 0;
    }

    public Money purchase(Purchasable purchasable) {
        if (!canPurchase(purchasable)) {
            throw new CanNotPurchaseException(this, purchasable);
        }
        final Money money = purchasable.price();
        return of(value - money.value);
    }

    public BigDecimal percentage(Money money) {
        if (isZero(money)) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(value).divide(BigDecimal.valueOf(money.value), 2, RoundingMode.DOWN);
    }

    public Money multiple(long multiple) {
        return Money.of(Math.multiplyExact(this.value, multiple));
    }

    public Money add(Money money) {
        if (isZero(money)) {
            return this;
        }
        return Money.of(this.value + money.value);
    }

    private static int parse(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new MoneyFormatException(value);
        }
        return Integer.parseInt(value);
    }

    private static long validated(long value) {
        if (value < 0) {
            throw new MoneyFormatException(value);
        }
        return value;
    }

    private static boolean isZero(Money money) {
        return money == null || money.value == 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Money money = (Money) other;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Money other) {
        return Long.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
