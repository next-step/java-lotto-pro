package lotto.domain;

import java.util.Map;

public class LottoResults {

    public static final int DEFALUT_COUNT = 0;
    public static final int ADD_COUNT_AMOUNT = 1;

    private final Map<LottoPrize, Integer> lottoResults;

    public LottoResults(Map<LottoPrize, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public Money findProfits() {
        int totalProfits = 0;
        for(Map.Entry<LottoPrize, Integer> lottoResult: lottoResults.entrySet()) {
            totalProfits += lottoResult.getKey().getLottoPrizeMoney() * lottoResult.getValue();
        }
        return new Money(totalProfits);
    }
}
