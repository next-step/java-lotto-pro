package study.step3.domain.lotto;

import study.step3.message.MoneyMessage;

public class Money {

    private static final long ZERO_MONEY = 0L;
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if(money < ZERO_MONEY) {
            throw new IllegalArgumentException(MoneyMessage.ERROR_MONEY_SHOULD_BE_AT_LEAST_ZERO.message());
        }
    }

    public static Money zero() {
        return of(ZERO_MONEY);
    }

    public static Money of(long money) {
        return new Money(money);
    }

    public long money() {
        return this.money;
    }

    public Money plus(Money otherMoney) {
        return new Money(this.money + otherMoney.money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return (int) (money ^ (money >>> 32));
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
