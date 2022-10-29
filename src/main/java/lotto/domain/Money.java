package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.Objects;
import common.constant.ErrorCode;

public class Money {

    private static final double FLOOR_LOCATION = 100;
    private static final int MIN_MONEY = 0;

    private final int money;

    private Money(int money) {
        validateMinPrice(money);
        this.money = money;
    }

    /**
     * Money 생성 시 사용하는 정적 팩토리 메소드
     * @param money 금액
     * @return new Money
     */
    public static Money createMoney(int money) {
        return new Money(money);
    }

    /**
     * 로또 구매 시 사용할 Money 생성 시 사용하는 정적 팩토리 메소드
     * 일반 createMoney와 달리, 로또 구매 최소 비용을 넘는지 확인한다.
     * @param money 로또 구매 시 사용할 금액
     * @return new Money
     */
    public static Money createLottoMoney(int money) {
        validateMinLottoPrice(money);
        return new Money(money);
    }

    private void validateMinPrice(int money) {
        if(money < MIN_MONEY) {
            throw new IllegalArgumentException(ErrorCode.돈은_양수여야_함.getErrorMessage());
        }
    }

    private static void validateMinLottoPrice(int money) {
        if (money < LOTTO_PRICE) {
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
