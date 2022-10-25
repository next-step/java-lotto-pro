package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Ranks {
    private final Map<Rank, Integer> countsOfRanks;

    public Ranks() {
        countsOfRanks = new HashMap<>();
    }

    public void add(final Rank rank) {
        Integer count = getCount(rank);
        countsOfRanks.put(rank, count + 1);
    }

    private Integer getCount(final Rank rank) {
        Integer count = countsOfRanks.get(rank);
        if(count == null) {
            count = 0;
        }
        return count;
    }

    public Map<Rank, Integer> getCountsOfRanks() {
        return countsOfRanks;
    }
}