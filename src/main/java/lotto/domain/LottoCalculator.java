package lotto.domain;

public class LottoCalculator {

    private LottoCalculator() {
    }

    public static int winningCount(WinningLotto winningLotto, Lottos lottos, Rank rank) {
        return (int) lottos.getLottos()
                .stream()
                .filter(lotto -> winningLotto.match(lotto) == rank)
                .count();
    }

    public static double rateOfReturn(WinningLotto winningLotto, Lottos lottos) {
        Money total = winningTotalMoney(winningLotto, lottos);
        return total.divide(Money.of(LottoCoin.LOTTO_PRICE * lottos.size()));
    }

    public static Money winningTotalMoney(WinningLotto winningLotto, Lottos lottos) {
        return Money.of(lottos.getLottos()
                .stream()
                .mapToLong(lotto -> winningLotto.match(lotto).getMoney())
                .sum());
    }
}
