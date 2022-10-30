package step3.domain;

public class Money {

    private int money;
    public static final int MIN_MONEY = 1000;
    public static final int MIN_SIZE = 0;
    public static final String LESS_THAN_MIN_SIZE = "[ERROR] 구입금액은 음수일 수 없습니다.";

    public Money(int value) {
        checkMoneyMinSize(value);
        this.money = value;
    }

    private void checkMoneyMinSize(int value) {
        if (value < MIN_SIZE) {
            throw new IllegalArgumentException(LESS_THAN_MIN_SIZE);
        }
    }

    public int calculateQuantity() {
        return this.money / MIN_MONEY;
    }

    public int getMoney() {
        return money;
    }
}
