package lotto.dto;

import lotto.LottoRankingStatus;
import lotto.LottoResults;

import java.util.Map;

public class LottoResultsDto {
    private final Map<LottoRankingStatus, Integer> lottoRankingAmounts;

    public LottoResultsDto(LottoResults lottoResults) {
        this.lottoRankingAmounts = lottoResults.getLottoRankingAmounts();
    }

    public Map<LottoRankingStatus, Integer> getLottoRankingAmounts() {
        return lottoRankingAmounts;
    }
}
