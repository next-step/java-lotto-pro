package study.lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class RankStatistics {

    public static final int DEFAULT_COUNT = 0;

    private final EnumMap<Rank, Integer> rankStatistics = new EnumMap<>(Rank.class);

    public RankStatistics(final List<Rank> ranks) {
        for (final Rank rank : ranks) {
            countUpByRank(rank);
        }
    }

    public static RankStatistics getInstance() {
        return new RankStatistics(Collections.emptyList());
    }

    public static RankStatistics valueOf(final List<Rank> ranks) {
        return new RankStatistics(ranks);
    }

    private void countUpByRank(Rank rank) {
        final Integer count = rankStatistics.getOrDefault(rank, DEFAULT_COUNT);
        rankStatistics.put(rank, count + 1);
    }

    public int countByRank(final Rank rank) {
        return this.rankStatistics.getOrDefault(rank, DEFAULT_COUNT);
    }

    public EnumMap<Rank, Integer> getRankStatistics() {
        return rankStatistics;
    }
}
