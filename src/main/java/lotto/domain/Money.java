package lotto.domain;

public class Money {

    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    public int getAmount() {
        return amount;
    }

}
