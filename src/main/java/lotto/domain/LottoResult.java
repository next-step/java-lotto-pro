package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    public static final int MIN_WINNING_NUM = 3;

    private final HashMap<Integer, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new HashMap<>();
    }

    public void putLottoResult(int collectNumberCnt) {
        lottoResult.put(collectNumberCnt, getLottoResult(collectNumberCnt) + 1);
    }

    public int getLottoResult(int collectNumberCnt) {
        return lottoResult.getOrDefault(collectNumberCnt, 0);
    }
}
