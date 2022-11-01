package lotto;

import java.util.Objects;

public final class Money {

    public static final Money ZERO = Money.amountOf(0);
    public static final Money ONE = Money.amountOf(1);

    private final int amount;

    private Money(final int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private static void validateAmount(final int amount) {
        if (amount < 0) {
            throw new LottoException("amount can not be negative");
        }
    }

    public static Money amountOf(final int amount) {
        return new Money(amount);
    }

    public Money divide(final Money other) {
        return new Money(this.amount / other.amount);
    }

    public boolean isLessThan(final Money other) {
        return amount < other.amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            '}';
    }
}
