package lotto.domain.profit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.win.WinRanking;

public class Profit {
    private final Lottos lottos;
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    private Profit(Lottos lottos, List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Profit of(Lottos lottos, List<LottoNumber> winningNumbers) {
        return new Profit(lottos, winningNumbers, null);
    }

    public static Profit of(Lottos lottos, List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        return new Profit(lottos, winningNumbers, bonusNumber);
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
        Map<WinRanking, Integer> winningCountByWinRanking = lottos.winResults(winningNumbers, bonusNumber);
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
