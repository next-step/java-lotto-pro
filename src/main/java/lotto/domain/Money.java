package lotto.domain;

import java.util.Objects;

public class Money {

    public final static int GAME_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validation(money);
        this.money = money;
    }

    public int getPurchaseCount() {
        return money / GAME_PRICE;
    }

    private void validation(int purchaseAmount) {
        validateZeroAmount(purchaseAmount);
        validateRemainderAmount(purchaseAmount);
    }

    private void validateRemainderAmount(int purchaseAmount) {
        if (purchaseAmount % GAME_PRICE > 0) {
            System.out.println("[ERROR] 구입 시도 금액이 잘못되었습니다.");
            throw new IllegalArgumentException("[ERROR] 구입 시도 금액이 잘못되었습니다.");
        }
    }

    private void validateZeroAmount(int purchaseAmount) {
        if (purchaseAmount == 0) {
            System.out.println("[ERROR] 구입 할 금액을 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 구입 할 금액을 입력해주세요.");
        }
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

}
