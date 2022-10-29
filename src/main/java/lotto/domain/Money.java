package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.Objects;
import common.constant.ErrorCode;

public class Money {

    private static final double FLOOR_LOCATION = 100;

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


    /**
     * 수익율 계산 메소드
     * @param profitMoney
     * @return 수익금 / 총 금액 -> 소숫점 둘째자리까지 반환
     */
    public double findProfitsRatio(Money profitMoney) {
        double profit = (double) profitMoney.money / this.money;
        return Math.floor(profit * FLOOR_LOCATION) / FLOOR_LOCATION;
    }

    public boolean isLessThan(Money otherMoney) {
        return this.money < otherMoney.money;
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
