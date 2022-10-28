package lotto.domain.statistic;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.win.WinRanking;

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

    public double profit() {
        LottoStatisticResults results = this.results();
        double winningAmount = results.winningMoney();
        double purchaseAmount = lottos.size() * LottoConstant.PRICE_OF_ONE_LOTTO;
        return winningAmount / purchaseAmount;
    }

    public boolean isLossProfit() {
        return this.profit() < 1;
    }
}
