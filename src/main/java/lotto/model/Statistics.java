package lotto.model;

import static lotto.view.ResultView.*;

public class Statistics {
    private final RankCount rankCount;
    private final Earning earning;

    private Statistics(RankCount rankCount, Earning earning) {
        this.rankCount = rankCount;
        this.earning = earning;
    }

    public static Statistics of(RankCount rankCount, Earning earning) {
        return new Statistics(rankCount, earning);
    }

    public void printStatistics() {
        printStatisticsHeader();
        printRankCount(rankCount);
        printEarning(earning);
    }
}
