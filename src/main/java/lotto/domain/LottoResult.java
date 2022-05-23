package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
    }

    public void add(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
    }

    public int getLottoPrize() {
        int prize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            prize += lottoResult.getOrDefault(lottoRank, 0) * lottoRank.getPrize();
        }
        return prize;
    }

    public Integer getMatchCount(LottoRank lottoRank) {
        return lottoResult.getOrDefault(lottoRank, 0);
    }

}
