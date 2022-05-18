package lotto.model;

import java.util.Map;
import lotto.constant.LottoRank;

public class LottoGameResult {

    private static final int NONE = 0;

    private final Map<LottoRank, Integer> resultRankMatchCountCache;

    public LottoGameResult(Map<LottoRank, Integer> resultRankMatchCountCache) {
        this.resultRankMatchCountCache = resultRankMatchCountCache;
    }

    public int rankCount(LottoRank lottoRank) {
        return resultRankMatchCountCache.getOrDefault(lottoRank, NONE);
    }

    public int totalWinningAmount() {
        int totalAmount = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            totalAmount += rankCount(lottoRank) * lottoRank.getWinningAmount();
        }
        return totalAmount;
    }
}
