package lotto.model.money;

import static lotto.constant.LottoSetting.LOTTO_UNIT_PRICE;

import java.util.Objects;

public class Money {

    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 0원 이상이어야 합니다.");
        }
        this.money = money;
    }

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public int possiblePurchaseLotto() {
        return money / LOTTO_UNIT_PRICE;
    }

    public int getMoney() {
        return this.money;
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
