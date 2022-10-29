package lotto.domain.profit;

import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.win.WinRanking;

public class Profit {
    private final Lottos lottos;
    private final List<LottoNumber> winningNumbers;

    private Profit(Lottos lottos, List<LottoNumber> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public static Profit of(Lottos lottos, List<LottoNumber> winningNumbers) {
        return new Profit(lottos, winningNumbers);
    }

    public double profit() {
        double purchasePrice = (double) lottos.size() * LottoConstant.PRICE_OF_ONE_LOTTO;
        double winningAmount = Arrays.stream(WinRanking.values())
                .map(this::winningAmountOf)
                .reduce(0.0, Double::sum);
        return Math.floor((winningAmount / purchasePrice) * 100) / 100;
    }

    private double winningAmountOf(WinRanking ranking) {
        return (double) lottos.winningCount(winningNumbers, ranking.getMatchCount()) * ranking.getWinningMoney();
    }


    public boolean isLossProfit() {
        return this.profit() < 1;
    }
}
