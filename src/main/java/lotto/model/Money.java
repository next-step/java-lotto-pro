package lotto.model;

import java.util.Objects;

public class Money {
    public static final int ZERO_NUM = 0;
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    private Money(int money) {
        validMoney(money);
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    private void validMoney(int money) {
        if (money < ZERO_NUM) {
            throw new IllegalArgumentException("음수가 입력되어 유효하지 않습니다.");
        }
    }

    public int maxLottoCount() {
        return money / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
