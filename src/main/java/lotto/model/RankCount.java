package lotto.model;

import lotto.enums.Rank;

import java.util.*;

public class RankCount {
    private final Map<Rank, Integer> rankCount;

    private RankCount(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }

    public static RankCount from(Map<Rank, Integer> rankCount) {
        return new RankCount(rankCount);
    }

    public int getCount(Rank rank) {
        return rankCount.get(rank);
    }
}
