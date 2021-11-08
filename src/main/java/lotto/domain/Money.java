package lotto.domain;

import lotto.exception.NegativeInputMoneyException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new NegativeInputMoneyException("0 이상의 수를 입력해야 합니다.");
        }
        this.money = money;
    }

    public int calculateTryLottoCount(int lottoPrice) {
        return this.money / lottoPrice;
    }

    public Money multiply(Integer count) {
        return new Money(this.money * count);
    }

    public Money plus(Money money) {
        return new Money(this.money + money.money);
    }

    public double calculateRate(Money money) {
        return new BigDecimal(this.money)
                .divide(new BigDecimal(money.money), 2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
