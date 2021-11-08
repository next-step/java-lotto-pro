package step3.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import step3.domain.LottoRanks;
import step3.domain.LottoResult;

public class LottoStatisticsResponseDto {
    private final LottoResult lottoResult;

    public LottoStatisticsResponseDto(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<LottoResultDto> getLottoResultDtos() {
        List<LottoResultDto> lottoResultDtos = new ArrayList<>();
        LottoRanks lottoRanks = lottoResult.getLottoRanks();

        for (LottoRanks.LottoRankResult lottoRank : lottoRanks.getLottoRankResults()) {
            LottoResultDto lottoResultDto = new LottoResultDto(
                lottoRank.getLottoRank().matchNumber,
                lottoRank.getLottoRank().prize,
                lottoRank.getLottoRank().name(),
                lottoRank.getWinningCount()
            );

            lottoResultDtos.add(lottoResultDto);
        }

        return lottoResultDtos;
    }

    public BigDecimal getYield() {
        return lottoResult.getCalculatedYield();
    }
}
