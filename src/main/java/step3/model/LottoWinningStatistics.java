package step3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoWinningStatistics {
    private final Map<Integer, Integer> lottoWinningStatistics = new HashMap<>();
    private final Money totalProfit = new Money(0);

    public LottoWinningStatistics(List<LottoResult> lottoResults, LottoResult winLottoResult) {
        initLottoWinningStatistics();
        setLottoWinningStatistics(lottoResults, winLottoResult);
        setTotalProfit();
    }

    private void initLottoWinningStatistics() {
        for (int i = 0; i < 7; i++) {
            this.lottoWinningStatistics.put(i, 0);
        }
    }

    private void setLottoWinningStatistics(List<LottoResult> lottoResults, LottoResult winLottoResult) {
        for (LottoResult lottoResult : lottoResults) {
            int matchedCount = lottoResult.getEqualCount(winLottoResult);
            setLottoWinningStatistic(matchedCount);
        }
    }

    private void setLottoWinningStatistic(int matchedCount) {
        this.lottoWinningStatistics.put(matchedCount, lottoWinningStatistics.get(matchedCount) + 1);
    }

    public Map<Integer, Integer> getLottoWinningStatistics() {
        return lottoWinningStatistics;
    }

    private void setTotalProfit() {
        for (int i = 0; i < lottoWinningStatistics.size(); i++) {
            LottoReward lottoReward = LottoReward.getLottoReward(i);
            totalProfit.plus(new Money(lottoReward.getProfitTotalMoney(lottoWinningStatistics.get(i))));
        }
    }

    public double getTotalProfitPercent(Money money) {
        return totalProfit.getPercent(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoWinningStatistics that = (LottoWinningStatistics) o;
        return Objects.equals(lottoWinningStatistics, that.lottoWinningStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningStatistics);
    }
}
