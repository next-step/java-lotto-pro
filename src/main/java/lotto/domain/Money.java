package lotto.domain;

public class Money {
    private static final int ZERO = 0;
    private final long money;

    public Money(final long money) {
        validate(money);
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    private void validate(final long money) {
        if (money < ZERO) {
            throw new IllegalArgumentException("마이너스 금액은 입력이 불가능 합니다.");
        }
    }
}
