package lotto.domain.statistic;

import java.util.List;
import lotto.domain.win.WinRanking;

public class LottoStatisticResults {
    private final List<LottoStatisticResult> results;

    private LottoStatisticResults(List<LottoStatisticResult> results) {
        this.results = results;
    }

    public static LottoStatisticResults from(List<LottoStatisticResult> results) {
        return new LottoStatisticResults(results);
    }

    public int winningCount(WinRanking winRaking) {
        for (LottoStatisticResult result : results) {
            if (result.getRanking() == winRaking) {
                return result.getMatchCount();
            }
        }
        return 0;
    }

    public double winningMoney() {
        return results.stream()
                .map(LottoStatisticResult::winningMoney)
                .reduce(0.0, Double::sum);
    }
}
