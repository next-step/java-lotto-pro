package step3.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import step3.domain.Amount;
import step3.domain.LottoRanks;

public class LottoStatisticsResponseDto {
    private final LottoRanks lottoRanks;

    public LottoStatisticsResponseDto(LottoRanks lottoResult) {
        this.lottoRanks = lottoResult;
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

    public BigDecimal getYield(Amount amount) {
        return lottoRanks.getCalculatedYield(amount);
    }
}
