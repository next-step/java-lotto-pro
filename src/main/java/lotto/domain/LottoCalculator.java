package lotto.domain;

public class LottoCalculator {

    private final static long LOTTO_PRICE = 1000;
    private final static Money LOTTO_MONEY = new Money(LOTTO_PRICE);

    private LottoCalculator() {
    }

    public static int availableToPurchaseCount(Money money) {
        if (!money.greaterEqualThan(LOTTO_MONEY)) {
            throw new IllegalArgumentException("로또를 구매하기에는 돈이 부족합니다.");
        }
        return money.quotient(LOTTO_MONEY);
    }


    public static int winningCount(WinningLotto winningLotto, Lottos lottos, Rank rank) {
        return (int) lottos.stream()
                .filter(lotto -> winningLotto.match(lotto) == rank)
                .count();
    }

    public static double rateOfReturn(WinningLotto winningLotto, Lottos lottos) {
        Money total = winningTotalMoney(winningLotto, lottos);
        return total.divide(new Money(LOTTO_PRICE * lottos.size()));
    }

    public static Money winningTotalMoney(WinningLotto winningLotto, Lottos lottos) {
        return lottos.stream()
                .map(lotto -> winningLotto.match(lotto).money())
                .reduce(new Money(0), Money::sum);
    }
}
