package lotto;

import java.util.Objects;

public class Money implements Comparable<Money> {

    public static final Money ONE_THOUSAND = of("1000");

    private final int value;

    protected Money(String value) {
        this(parse(value));
    }

    protected Money(int value) {
        this.value = validated(value);
    }

    public static Money of(String value) {
        return new Money(value);
    }

    public static Money of(int value) {
        return new Money(value);
    }

    public boolean canPurchase(Purchasable purchasable) {
        if (purchasable == null) {
            return false;
        }
        final Money money = purchasable.price();
        int i = compareTo(money);
        return i >= 0;
    }

    public Money purchase(Purchasable purchasable) {
        if (!canPurchase(purchasable)) {
            throw new CanNotPurchaseException(this, purchasable);
        }
        final Money money = purchasable.price();
        return of(value - money.value);
    }

    private static int parse(String value) {
        if (value == null || value.isEmpty()) {
            throw new MoneyFormatException(value);
        }
        return Integer.parseInt(value);
    }

    private static int validated(int value) {
        if (value < 0) {
            throw new MoneyFormatException(value);
        }
        return value;
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
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
