package study.lotto.model;

import java.util.EnumMap;

public class RankStatistics {

    public static final int DEFAULT_COUNT = 0;
    private static final int INIT_COUNT = 1;

    private final EnumMap<Rank, Integer> rankStatistics;

    public RankStatistics() {
        this.rankStatistics = new EnumMap<>(Rank.class);
    }

    private RankStatistics(final EnumMap<Rank, Integer> rankStatistics) {
        this.rankStatistics = rankStatistics;
    }

    public static RankStatistics getInstance() {
        return new RankStatistics();
    }

    public void countUpByRank(Rank rank) {
        if (rankStatistics.containsKey(rank)) {
            final Integer count = rankStatistics.get(rank);
            rankStatistics.put(rank, count + 1);
            return;
        }
        rankStatistics.put(rank, INIT_COUNT);
    }

    public int countByRank(final Rank rank) {
        return this.rankStatistics.getOrDefault(rank, DEFAULT_COUNT);
    }

    public static RankStatistics valueOf(EnumMap<Rank, Integer> rankStatistics) {
        return new RankStatistics(rankStatistics);
    }

    public EnumMap<Rank, Integer> getRankStatistics() {
        return rankStatistics;
    }
}
