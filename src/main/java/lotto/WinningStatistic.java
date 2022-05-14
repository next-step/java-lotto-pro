package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistic {

    public static final int NO_WIN = 0;

    private final Map<Rank, Integer> statistic = new HashMap<>();

    public int count(Rank rank) {
        return statistic.getOrDefault(rank, NO_WIN);
    }

    public void collect(Rank rank) {
        statistic.put(rank, count(rank) + 1);
    }
}
