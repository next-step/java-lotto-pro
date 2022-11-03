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

    public LottoNumberMatchCount getFirstRankLottoNumberMatchCount() {
        return LottoResult.FIRST.getLottoNumberMatchCount();
    }

    public int getFirstRankCount() {
        return getCountOf(LottoResult.FIRST);
    }

    public Money getFirstRankPrizeMoney() {
        return LottoResult.FIRST.getPrizeMoney();
    }

    public LottoNumberMatchCount getSecondRankLottoNumberMatchCount() {
        return LottoResult.SECOND.getLottoNumberMatchCount();
    }

    public int getSecondRankCount() {
        return getCountOf(LottoResult.SECOND);
    }

    public Money getSecondRankPrizeMoney() {
        return LottoResult.SECOND.getPrizeMoney();
    }

    public LottoNumberMatchCount getThirdRankLottoNumberMatchCount() {
        return LottoResult.THIRD.getLottoNumberMatchCount();
    }

    public int getThirdRankCount() {
        return getCountOf(LottoResult.THIRD);
    }

    public Money getThirdRankPrizeMoney() {
        return LottoResult.THIRD.getPrizeMoney();
    }

    public LottoNumberMatchCount getFourthRankLottoNumberMatchCount() {
        return LottoResult.FOURTH.getLottoNumberMatchCount();
    }

    public int getFourthRankCount() {
        return getCountOf(LottoResult.FOURTH);
    }

    public Money getFourthRankPrizeMoney() {
        return LottoResult.FOURTH.getPrizeMoney();
    }

    private int getCountOf(final LottoResult result) {
        return resultCounts.getOrDefault(result, DEFAULT_COUNT);
    }

    private void accept(final LottoResult result) {
        resultCounts.put(result, resultCounts.getOrDefault(result, DEFAULT_COUNT) + 1);
    }


}
