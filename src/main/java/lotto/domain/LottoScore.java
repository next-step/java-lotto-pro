package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoScore {

    private static final Integer ZERO = 0;
    private Map<Rank, Integer> rankMap;

    public LottoScore() {
        rankMap = initRankMap();
    }

    private Map<Rank, Integer> initRankMap() {
        this.rankMap = new HashMap<>();

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
        if (rankMap.get(rank) != null) {
            int count = rankMap.get(rank);
            rankMap.put(rank, ++count);
            return;
        }

        rankMap.put(rank, 1);
    }

    public Winnings getWinnings() {
        int winnings = 0;

        for (Map.Entry<Rank, Integer> elem : rankMap.entrySet()) {
            winnings += elem.getKey().getWinningsMoney() * elem.getValue();
        }

        return new Winnings(winnings);
    }
}
