package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningRanks {
    private final List<WinningRank> winningRanks;

    public WinningRanks(List<WinningRank> winningRanks) {
        this.winningRanks = winningRanks;
    }

    public static WinningRanks of(List<WinningRank> winningRanks) {
        return new WinningRanks(winningRanks);
    }

    public double calculateEarningRatio(LottoPurchaseAmount lottoPurchaseAmount) {
        return lottoPurchaseAmount.calculateEarningRatio(earningAmount());
    }

    private long earningAmount() {
        return winningRanks.stream()
                .mapToLong(WinningRank::getWinningMoney)
                .sum();
    }

    public String statistics() {
        Map<WinningRank, Long> statisticsMap = new LinkedHashMap<>();
        for (WinningRank winningRank : WinningRank.values()) {
            statisticsMap.put(winningRank, countSameWiningRank(winningRank));
        }
        return getStatisticsMessage(statisticsMap);
    }

    public String getStatisticsMessage(Map<WinningRank, Long> statisticsMap) {
        StringBuilder sb = new StringBuilder();
        statisticsMap.forEach((winningRank, winningCount) ->
                sb.append(winningRank.getStatisticsMessage(winningCount))
        );
        return sb.toString();
    }

    private Long countSameWiningRank(WinningRank winningRank) {
        return winningRanks.stream()
                .filter(w -> w.equals(winningRank))
                .count();
    }
}
