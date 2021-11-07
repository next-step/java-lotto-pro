package lotto.dto;

import lotto.domain.LottoRankingStatus;
import lotto.domain.LottoResults;

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
