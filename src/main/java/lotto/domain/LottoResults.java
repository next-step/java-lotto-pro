package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoResults {

    public static final int DEFALUT_COUNT = 0;
    public static final int ADD_COUNT_AMOUNT = 1;

    private final Map<LottoPrize, Integer> lottoResults;

    private LottoResults(Map<LottoPrize, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults createLottoResults(Map<LottoPrize, Integer> lottoResults) {
        return new LottoResults(Collections.unmodifiableMap(lottoResults));
    }

    public Money findProfits() {
        int totalProfits = 0;
        for(Map.Entry<LottoPrize, Integer> lottoResult: lottoResults.entrySet()) {
            totalProfits += lottoResult.getKey().getLottoPrizeMoney() * lottoResult.getValue();
        }
        return Money.createMoney(totalProfits);
    }

    public int findLottoResultCount(LottoPrize lottoPrize) {
        return lottoResults.getOrDefault(lottoPrize, DEFALUT_COUNT);
    }
}
