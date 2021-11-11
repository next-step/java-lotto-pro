package study.lotto.model;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

public class WinningStatistics {

    private final IncomeRate incomeRate; // 당첨율
    private final RankStatistics rankStatistics; // 당첨 등수 통계

    private WinningStatistics(final List<Rank> refereedRanks) {
        this.incomeRate = IncomeRate.valueOf(refereedRanks);
        this.rankStatistics = RankStatistics.valueOf(refereedRanks);
    }

    public static WinningStatistics valueOf(final List<Rank> ranks) {
        return new WinningStatistics(ranks);
    }

    public double getIncomeRate() {
        return incomeRate.getIncomeRate();
    }

    public EnumMap<Rank, Integer> getRankStatistics() {
        return rankStatistics.getRankStatistics();
    }

    public int countByRank(final Rank rank) {
        return rankStatistics.countByRank(rank);
    }
}
