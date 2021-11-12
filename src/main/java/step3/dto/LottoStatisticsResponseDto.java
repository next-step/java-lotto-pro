package step3.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import step3.domain.LottoRanks;

public class LottoStatisticsResponseDto {
    private final LottoRanks lottoRanks;

    public LottoStatisticsResponseDto(LottoRanks lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<LottoResultDto> getLottoResultDtos() {
        List<LottoResultDto> lottoResultDtos = new ArrayList<>();

        for (LottoRanks.LottoRankResult lottoRankResult : lottoRanks.getLottoRankResults()) {
            LottoResultDto lottoResultDto = new LottoResultDto(lottoRankResult);

            lottoResultDtos.add(lottoResultDto);
        }

        return lottoResultDtos;
    }

    public BigDecimal getYield() {
        return lottoRanks.getCalculatedYield();
    }
}
