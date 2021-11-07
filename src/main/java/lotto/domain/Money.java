package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

import java.math.BigDecimal;
import java.util.Objects;

import static lotto.domain.LottoNumber.GAME_PRICE;

public class Money {

    private final BigDecimal money;

    public Money(BigDecimal money) {
        validation(money);
        this.money = money;
    }

    public int getPurchaseCount(BigDecimal gamePrice) {
        return money.divide(gamePrice).intValue();
    }

    private void validation(BigDecimal purchaseAmount) {
        validateZeroAmount(purchaseAmount);
        validateRemainderAmount(purchaseAmount);
    }

    private void validateRemainderAmount(BigDecimal purchaseAmount) {
        if (!purchaseAmount.remainder(GAME_PRICE).equals(BigDecimal.ZERO)) {
            System.out.println("[ERROR] 구입 시도 금액이 잘못되었습니다.");
            throw new LottoPurchaseAmountException("[ERROR] 구입 시도 금액이 잘못되었습니다.");
        }
    }

    private void validateZeroAmount(BigDecimal purchaseAmount) {
        if (purchaseAmount.equals(BigDecimal.ZERO)) {
            System.out.println("[ERROR] 구입 할 금액을 입력해주세요.");
            throw new LottoPurchaseAmountException("[ERROR] 구입 할 금액을 입력해주세요.");
        }
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
