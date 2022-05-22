package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
    }

    public void add(int matchCount) {
        lottoResult.put(matchCount, lottoResult.getOrDefault(matchCount, 0) + 1);
    }

    public int getLottoPrize() {
        int prize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            prize += lottoResult.getOrDefault(lottoRank.getMatchCount(), 0) * lottoRank.getPrize();
        }
        return prize;
    }

    public Integer getMatchCount(int matchCount) {
        return lottoResult.getOrDefault(matchCount, 0);
    }

}
