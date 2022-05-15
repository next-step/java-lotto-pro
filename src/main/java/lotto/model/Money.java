package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private static final int ZERO_NUM = 0;
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

    public Money multiply(int count) {
        return Money.from(Math.multiplyExact(this.money, count));
    }

    public Money add(Money money) {
        return Money.from(Math.addExact(this.money, money.money));
    }

    public BigDecimal divideBy(Money money) {
        if (isZero(money)) {
            throw new IllegalArgumentException("0원으로 나눌 수 없습니다.");
        }
        return BigDecimal.valueOf(this.money).divide(BigDecimal.valueOf(money.money), 2, RoundingMode.DOWN);
    }

    private boolean isZero(Money money) {
        return money.money == ZERO_NUM;
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

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
