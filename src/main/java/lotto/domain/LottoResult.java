package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT_VALUE = 0;
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
    }

    public void add(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, DEFAULT_VALUE) + INCREMENT_VALUE);
    }

    public int getLottoPrize() {
        int prize = DEFAULT_VALUE;
        for (LottoRank lottoRank : LottoRank.values()) {
            prize += lottoResult.getOrDefault(lottoRank, DEFAULT_VALUE) * lottoRank.getPrize();
        }
        return prize;
    }

    public Integer getMatchCount(LottoRank lottoRank) {
        return lottoResult.getOrDefault(lottoRank, DEFAULT_VALUE);
    }

}
