package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 0 이상이어야 합니다. (입력값: " + money + ")");
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public boolean isLessThan(int money) {
        return this.money < money;
    }

    public int divide(int money) {
        return this.money / money;
    }
}
