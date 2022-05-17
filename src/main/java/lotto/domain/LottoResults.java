package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResults {
    private final Map<LottoRank, Integer> resultList;

    public LottoResults() {
        resultList = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            resultList.put(rank, 0);
        }
    }

    public void increaseRankCount(LottoRank rank) {
        resultList.put(rank, resultList.get(rank) + 1);
    }

    public Integer getRankCount(LottoRank rank) {
        return resultList.get(rank);
    }
}
