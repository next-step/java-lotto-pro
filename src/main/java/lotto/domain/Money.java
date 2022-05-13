package lotto.domain;

public class Money {
    private long money;

    public Money(String input) {
        try {
            money = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 액수입니다.");
        }

        if (isInvalidMoney(money)) {
            throw new IllegalArgumentException("유효하지 않은 액수입니다.");
        }
    }

    public Money(long input) {
        this(String.valueOf(input));
    }

    private boolean isInvalidMoney(long money) {
        return money < 0;
    }

    public long getMoney() {
        return money;
    }
}
