package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottosResults {
    private final Map<LottoRank, Integer> resultList;

    public LottosResults() {
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
