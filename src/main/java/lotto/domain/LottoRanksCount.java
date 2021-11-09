package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRanksCount {
    private final Map<Rank, Integer> lottoRanksCount;

    public LottoRanksCount(List<Rank> lottoRanks) {
        this.lottoRanksCount = createRanksCount(lottoRanks);
    }

    private Map<Rank, Integer> createRanksCount(List<Rank> lottoRanks) {
        Map<Rank, Integer> ranksCount = new HashMap<>();
        for (Rank lottoRank : lottoRanks) {
            ranksCount.put(lottoRank, ranksCount.getOrDefault(lottoRank, RankCount.RANK_DEFAULT_COUNT.count) + RankCount.RANK_PLUS_COUNT.count);
        }
        return ranksCount;
    }

    public long getRankCount(Rank rank) {
        return lottoRanksCount.getOrDefault(rank, RankCount.RANK_DEFAULT_COUNT.count);
    }

    private enum RankCount {
        RANK_DEFAULT_COUNT(0),
        RANK_PLUS_COUNT(1);

        private final int count;

        RankCount(int count) {
            this.count = count;
        }
    }
}
