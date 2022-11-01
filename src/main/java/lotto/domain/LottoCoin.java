package lotto.domain;

import java.util.Objects;

public class LottoCoin {

    public final static long LOTTO_PRICE = 1000;
    private final static Money LOTTO_MONEY = Money.of(LOTTO_PRICE);
    private final int coins;

    private LottoCoin(int coins) {
        this.coins = coins;
    }

    public static LottoCoin empty() {
        return new LottoCoin(0);
    }

    public static LottoCoin of(Money money) {
        return new LottoCoin(availableToPurchaseCount(money));
    }

    public static int availableToPurchaseCount(Money money) {
        if (!money.greaterEqualThan(LOTTO_MONEY)) {
            throw new IllegalArgumentException("로또를 구매하기에는 돈이 부족합니다.");
        }
        return money.quotient(LOTTO_MONEY);
    }

    public boolean isEmpty() {
        if (this.coins == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.coins;
    }

    public LottoCoin pop(int size) {
        vaildatePop(size);
        return new LottoCoin(size);
    }

    private void vaildatePop(int size) {
        if (isEmpty()) {
            throw new IllegalArgumentException("더이상 로또 코인이 없습니다.");
        }
        if (size > this.coins || size < 0) {
            throw new IllegalArgumentException("로또 코인은 1개 ~ 최대 코인 개수 이하만 꺼낼 수 있습니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoCoin)) return false;
        LottoCoin lottoCoin = (LottoCoin) o;
        return coins == lottoCoin.coins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coins);
    }
}
