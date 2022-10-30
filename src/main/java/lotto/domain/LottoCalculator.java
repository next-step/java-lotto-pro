package lotto.domain;

public class LottoCalculator {

    private final static Money LOTTO_PRICE = new Money(1000);

    private LottoCalculator() {
    }

    public static int availableToPurchaseCount(Money money) {
        if (!money.greaterEqualThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException("로또를 구매하기에는 돈이 부족합니다.");
        }
        return money.quotient(LOTTO_PRICE);
    }


    public static int winningCount(WinningLotto winningLotto, Lottos lottos, Rank rank) {
        return (int) lottos.stream().filter(lotto -> winningLotto.match(lotto) == rank).count();
    }
}
