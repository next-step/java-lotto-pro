package lotto.statistic;

import java.util.List;
import lotto.money.Money;
import lotto.win.WinRanking;

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

    public Money winningMoney() {
        Money winningMoney = Money.from(0);
        for (LottoStatisticResult result : results) {
            winningMoney = winningMoney.add(result.winningMoney());
        }
        return winningMoney;
    }
}
