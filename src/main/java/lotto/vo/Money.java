package lotto.vo;

public class Money {
    private final static String NEGATIVE_AMOUNTS_OR_ZERO_CANNOT_BE_ENTERED = "1원 보다 작은 금액은 입력할 수 없습니다.";

    private int money;

    public Money(int money) {
        if (money < 1) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNTS_OR_ZERO_CANNOT_BE_ENTERED);
        }
        this.money = money;
    }

    public int value() {
        return money;
    }
}
