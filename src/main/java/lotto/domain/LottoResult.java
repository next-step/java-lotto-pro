package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    public static final int ZERO = 0;
    private Map<LottoWinningRank, Integer> result;

    public LottoResult(){
        result = new HashMap<>();
    }

    public static LottoResult create(){
        LottoResult lottoResult = new LottoResult();
        lottoResult.result = new HashMap<>();

        return lottoResult;
    }

    public void addLottoResult(LottoWinningRank lottoRank) {
        result.put(lottoRank, result.getOrDefault(lottoRank, ZERO) + 1);
    }

    public int getResultCount(LottoWinningRank winningEnum) {
        return result.getOrDefault(winningEnum, ZERO);
    }

    public long calculateWinningMoney() {
        long totalWinningMoney = 0L;
        for (LottoWinningRank key : result.keySet()) {
            totalWinningMoney += key.getWinningMoney() * result.getOrDefault(key, ZERO);
        }
        return totalWinningMoney;
    }
}
