package lotto.domain;

public class Money {
    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money from(int money) {
        return new Money(money);
    }
}
