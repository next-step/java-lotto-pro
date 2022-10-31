package lotto.domain.profit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLottos;
import lotto.domain.win.WinRanking;

public class Profit {
    private final List<Lotto> lottos;
    private final WinningLottos winningLottos;

    private Profit(List<Lotto> lottos, WinningLottos winningLottos) {
        this.lottos = lottos;
        this.winningLottos = winningLottos;
    }

    public static Profit of(List<Lotto> lottos, WinningLottos winningLottos) {
        return new Profit(lottos, winningLottos);
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
        Map<WinRanking, Integer> winningCountByWinRanking = winningLottos.winResults(lottos);
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
