package lotto.domain;

import java.util.*;

public class Ranks {

    private static final List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.MISS);
    private final Map<Rank, Integer> countsOfRanks;

    public Ranks() {
        countsOfRanks = new TreeMap<>(Comparator.comparingInt(Rank::getCountOfMatch));
        for(Rank rank : ranks) {
            countsOfRanks.put(rank, 0);
        }
    }

    public void add(final Rank rank) {
        int count = countsOfRanks.get(rank);
        countsOfRanks.put(rank, count + 1);
    }

    public Map<Rank, Integer> getCountsOfRanks() {
        return countsOfRanks;
    }
}