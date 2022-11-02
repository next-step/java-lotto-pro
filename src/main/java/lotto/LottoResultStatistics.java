package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LottoResultStatistics {

    private static final int DEFAULT_COUNT = 0;

    private final Map<LottoResult, Integer> resultCounts;

    public LottoResultStatistics(final List<LottoResult> lottoResults) {
        resultCounts = new HashMap<>();
        for (final LottoResult lottoResult : lottoResults) {
            accept(lottoResult);
        }
    }

    public Integer getCountOf(final LottoResult result) {
        return resultCounts.getOrDefault(result, DEFAULT_COUNT);
    }

    private void accept(final LottoResult result) {
        resultCounts.put(result, resultCounts.getOrDefault(result, DEFAULT_COUNT) + 1);
    }

}
