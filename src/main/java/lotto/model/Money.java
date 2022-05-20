package lotto.model;

import java.util.Objects;

public class Money {
    private final static int MINIMUM_AMOUNT_AVAILABLE = 1;
    private final static int STORE_LIMIT_AMOUNT = 100000;
    private final static String NEGATIVE_AMOUNTS_OR_ZERO_CANNOT_BE_ENTERED = "1원 보다 작은 금액은 입력할 수 없습니다.";
    private final static String AMOUNT_THAT_CAN_BE_USED_AT_THE_STORE_IS_LIMITED_TO_100000_AT_A_TIME = "판매점에서 사용 가능한 금액은 1회 10만원으로 제한됩니다.";

    private int money;

    public Money(int money) {
        if (money < MINIMUM_AMOUNT_AVAILABLE) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNTS_OR_ZERO_CANNOT_BE_ENTERED);
        }
        if (money > STORE_LIMIT_AMOUNT) {
            throw new IllegalArgumentException(AMOUNT_THAT_CAN_BE_USED_AT_THE_STORE_IS_LIMITED_TO_100000_AT_A_TIME);
        }
        this.money = money;
    }

    public int value() {
        return money;
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
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}
