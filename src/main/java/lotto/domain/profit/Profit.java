package lotto.domain.profit;

import java.util.Arrays;
import java.util.Map;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.win.WinRanking;

public class Profit {
    private final Lottos lottos;
    private final WinningLotto winningLotto;

    private Profit(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public static Profit of(Lottos lottos, WinningLotto winningLotto) {
        return new Profit(lottos, winningLotto);
    }

    public double profit() {
        double purchasePrice = calculatePurchasePrice();
        double winningAmount = calculateWinningAmount();
        return Math.floor((winningAmount / purchasePrice) * 100) / 100;
    }

    private double calculatePurchasePrice() {
        return (double) lottos.size() * LottoConstant.PRICE_OF_ONE_LOTTO;
    }

    private double calculateWinningAmount() {
        Map<WinRanking, Integer> winningCountByWinRanking = winningLotto.winResults(lottos);
        return Arrays.stream(WinRanking.values())
                .map(ranking -> winningAmount(
                        winningCountByWinRanking.getOrDefault(ranking, LottoConstant.EMPTY_WINNING_COUNT), ranking))
                .reduce(0.0, Double::sum);
    }

    private double winningAmount(int winningCount, WinRanking ranking) {
        return (double) winningCount * ranking.getWinningMoney();
    }


    public boolean isLossProfit() {
        return this.profit() < 1;
    }
}
