package lotto.dto;

import lotto.domain.LottoRankMatcher;

public class LottoResultDto {

    private LottoRankMatcher lottoNumberMatcher;
    private double profit;

    public LottoResultDto(LottoRankMatcher lottoNumberMatcher, double profit) {
        this.lottoNumberMatcher=lottoNumberMatcher;
        this.profit=profit;
    }


    public LottoRankMatcher getLottoNumberMatcher() {
        return lottoNumberMatcher;
    }

    public double getProfit() {
        return profit;
    }

}
