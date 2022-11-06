package lotto;

import java.util.Objects;

public class Money {

    private final long amount;

    private Money(long amount) {
        this(String.valueOf(amount));
    }

    public Money(String amount) {
        try {
            this.amount = Long.parseLong(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("금액은 숫자여야 합니다. 입력 값:" + amount);
        }
    }

    public long divide(Money operandMoney) {
        return this.amount / operandMoney.getAmount();
    }

    public long getAmount() {
        return amount;
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
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public static Money from(long amount) {
        return new Money(amount);
    }
}
