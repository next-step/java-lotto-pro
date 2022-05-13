package lotto.domain;

public class Money {

    private int money;

    private Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int divide(int divisor) {
        if (divisor == 0) throw new IllegalArgumentException();
        return money/divisor;
    }
}
