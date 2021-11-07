package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

import java.math.BigDecimal;
import java.util.Objects;

import static lotto.domain.LottoNumber.GAME_PRICE;

public class Money {

    private final BigDecimal money;

    public Money(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
