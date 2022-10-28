package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningRanks {
    private static final String PRINT_STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개";
    public static final String PRINT_FORMAT_RATIO = "총 수익률은 %.2f입니다.";

    private final List<WinningRank> winningRanks;

    public WinningRanks(List<WinningRank> winningRanks) {
        this.winningRanks = winningRanks;
    }

    public static WinningRanks of(List<WinningRank> winningRanks) {
        return new WinningRanks(winningRanks);
    }

    public void printEarningRatio(LottoPurchaseAmount lottoPurchaseAmount) {
        double earningRatio = calculateEarningRatio(lottoPurchaseAmount);
        System.out.printf(PRINT_FORMAT_RATIO, earningRatio);
    }

    private double calculateEarningRatio(LottoPurchaseAmount lottoPurchaseAmount) {
        return lottoPurchaseAmount.calculateEarningRatio(earningAmount());
    }

    private long earningAmount() {
        return winningRanks.stream()
                .mapToLong(WinningRank::getWinningMoney)
                .sum();
    }

    public void statistics() {
        Map<WinningRank, Long> statisticsMap = new LinkedHashMap<>();
        for (WinningRank winningRank : WinningRank.values()) {
            statisticsMap.put(winningRank, countSameWiningRank(winningRank));
        }
        printStatistics(statisticsMap);
    }

    private static void printStatistics(Map<WinningRank, Long> statisticsMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        statisticsMap.forEach((winningRank, winningCount) -> {
            if (winningRank.isDisplay()) {
                System.out.printf((PRINT_STATISTICS_FORMAT) + "%n",
                        winningRank.getMatchCount(),
                        winningRank.getWinningMoney(),
                        winningCount);
            }
        });
    }

    private Long countSameWiningRank(WinningRank winningRank) {
        return winningRanks.stream()
                .filter(w -> w.equals(winningRank))
                .count();
    }
}