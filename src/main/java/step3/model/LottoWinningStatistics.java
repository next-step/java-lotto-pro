package step3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoWinningStatistics {
    private final Map<Integer, Integer> lottoWinningStatistics = new HashMap<>();
    private double totalProfit = 0;

    public LottoWinningStatistics(List<LottoResult> lottoResults, LottoResult winLottoResult) {
        setLottoWinningStatistics(lottoResults, winLottoResult);
        setTotalProfit();
    }

    private void setLottoWinningStatistics(List<LottoResult> lottoResults, LottoResult winLottoResult) {
        for (LottoResult lottoResult : lottoResults) {
            int matchedCount = lottoResult.getEqualCount(winLottoResult);
            this.lottoWinningStatistics.put(
                    matchedCount,
                    lottoWinningStatistics.get(matchedCount) != null ? lottoWinningStatistics.get(matchedCount) + 1 : 1
            );
        }
    }

    private void setTotalProfit() {
        for (Integer matchCount : lottoWinningStatistics.keySet()) {
            LottoReward lottoReward = LottoReward.getWinMoney(matchCount);
            totalProfit += lottoReward.getMoney();
        }
    }

    public double getTotalProfitPercent(int money) {
        System.out.println("money : " + money);
        System.out.println("totalProfit : " + totalProfit);
        return totalProfit / money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningStatistics that = (LottoWinningStatistics) o;
        return Objects.equals(lottoWinningStatistics, that.lottoWinningStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningStatistics);
    }
}
