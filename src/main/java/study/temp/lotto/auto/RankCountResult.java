package study.temp.lotto.auto;

import java.util.HashMap;
import java.util.Map;

public class RankCountResult {

    private final Map<Ranking, Count> countOfRank = new HashMap<>();

    public RankCountResult() {
        countOfRank.put(Ranking.FIRST, new Count());
        countOfRank.put(Ranking.SECOND, new Count());
        countOfRank.put(Ranking.THIRD, new Count());
        countOfRank.put(Ranking.FOURTH, new Count());
        countOfRank.put(Ranking.FIFTH, new Count());
        countOfRank.put(Ranking.MISS, new Count());
    }

    public void renew(Ranking rank) {
        Count count = countOfRank.get(rank);
        count.increase();
    }

    public int getCount(Ranking ranking) {
        return countOfRank.get(ranking).getCount();
    }

    public Map<Ranking, Count> getCountOfRank() {
        return countOfRank;
    }
}
