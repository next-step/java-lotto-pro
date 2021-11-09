package step3.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import step3.domain.Amount;
import step3.domain.LottoRanks;

public class LottoStatisticsResponseDto {
    private final LottoRanks lottoRanks;
    private final Amount amount;

    public LottoStatisticsResponseDto(LottoRanks lottoResult, Amount amount) {
        this.lottoRanks = lottoResult;
        this.amount = amount;
    }

    public List<LottoResultDto> getLottoResultDtos() {
        List<LottoResultDto> lottoResultDtos = new ArrayList<>();

        for (LottoRanks.LottoRankResult lottoRankResult : lottoRanks.getLottoRankResults()) {
            LottoResultDto lottoResultDto = new LottoResultDto(
                lottoRankResult.getLottoRank().matchNumber,
                lottoRankResult.getLottoRank().prize,
                lottoRankResult.getLottoRank().name(),
                lottoRankResult.getWinningCount()
            );

            lottoResultDtos.add(lottoResultDto);
        }

        return lottoResultDtos;
    }

    @Deprecated
    public BigDecimal getYield(Amount amount) {
        return lottoRanks.getCalculatedYield(amount);
    }

    public BigDecimal getYield() {
        return lottoRanks.getCalculatedYield(amount);
    }
}
