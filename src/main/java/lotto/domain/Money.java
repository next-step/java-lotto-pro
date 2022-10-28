package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.Objects;
import lotto.constant.ErrorCode;

public class Money {

    private final int money;

    public Money(int money) {
        validateMinPrice(money);
        this.money = money;
    }

    private void validateMinPrice(int money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorCode.로또를_구매하기_위해서는_1000원_이상_필요.getErrorMessage());
        }
    }

    public int maxLottoCount() {
        return money / LOTTO_PRICE;
    }

    public double findProfit(Money money) {
        double profit = (double) money.money / this.money;
        return Math.floor(profit * 100) / 100;
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
