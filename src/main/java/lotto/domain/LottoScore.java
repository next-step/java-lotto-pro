package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LottoScore {

    private static final Integer ZERO = 0;
    private Map<Rank, Integer> rankMap;

    public LottoScore() {
        rankMap = initRankMap();
    }

    private Map<Rank, Integer> initRankMap() {
        this.rankMap = new TreeMap<>((o1, o2) -> o2.getWinningsMoney() - o1.getWinningsMoney());

        for (Rank rank : Rank.values()) {
            rankMap.put(rank, ZERO);
        }

        rankMap.remove(Rank.MISS);
        return rankMap;
    }

    public Map<Rank, Integer> getRankMap() {
        return Collections.unmodifiableMap(rankMap);
    }

    public void addScore(Rank rank) {
        if (rank.isNotMiss()) {
            int count = rankMap.get(rank);
            rankMap.put(rank, ++count);
        }
    }

    public Winnings getWinnings() {
        int winnings = 0;

        for (Map.Entry<Rank, Integer> elem : rankMap.entrySet()) {
            winnings += elem.getKey().getWinningsMoney() * elem.getValue();
        }

        return new Winnings(winnings);
    }
}
