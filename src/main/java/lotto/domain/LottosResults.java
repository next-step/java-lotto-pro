package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottosResults {
    private final Map<LottoRank, Integer> resultMap;

    public LottosResults() {
        resultMap = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void increaseRankCount(LottoRank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public Integer getRankCount(LottoRank rank) {
        return resultMap.get(rank);
    }

    public Integer calculateTotalMoney() {
        int totalMoney = 0;

        for(LottoRank key : resultMap.keySet()) {
            totalMoney += key.getWinningMoney() * resultMap.get(key);
        }

        return totalMoney;
    }

}
