package lotto.model;

import java.util.Map;
import lotto.constant.LottoRank;

public class LottoGameResult {

    private static final int NONE = 0;

    private final Map<LottoRank, Integer> resultCountMap;

    public LottoGameResult(Map<LottoRank, Integer> resultCountMap) {
        this.resultCountMap = resultCountMap;
    }

    public int rankCount(LottoRank lottoRank) {
        return resultCountMap.getOrDefault(lottoRank, NONE);
    }

    public int totalWinningAmount() {
        int totalAmount = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            totalAmount += rankCount(lottoRank) * lottoRank.getWinningAmount();
        }
        return totalAmount;
    }
}
