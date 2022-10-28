package lotto.statistic;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoNumbers;
import lotto.Lottos;
import lotto.money.Money;
import lotto.win.WinRanking;

public class LottoStatistic {
    private final Lottos lottos;
    private final LottoNumbers winningNumbers;

    private LottoStatistic(Lottos lottos, LottoNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public static LottoStatistic of(Lottos lottos, LottoNumbers winningNumbers) {
        return new LottoStatistic(lottos, winningNumbers);
    }


    public LottoStatisticResults results() {
        List<LottoStatisticResult> results = new ArrayList<>();

        for (WinRanking winRanking : WinRanking.values()) {
            int matchCount = lottos.matches(winRanking.getMatchCount(), winningNumbers);
            results.add(LottoStatisticResult.of(winRanking, matchCount));
        }

        return LottoStatisticResults.from(results);
    }

    public double profit(Money priceOfOneLotto) {
        LottoStatisticResults results = this.results();
        Money winningAmount = results.winningMoney();
        Money purchasePrice = priceOfOneLotto.multiply(lottos.size());
        return winningAmount.divide(purchasePrice);
    }

    public boolean isLossProfit(Money priceOfOneLotto) {
        return this.profit(priceOfOneLotto) < 1;
    }
}
