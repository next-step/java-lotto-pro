package lotto.dto;

import lotto.domain.LottoRankMatcher;
import lotto.domain.Rank;

import java.util.Map;

public class LottoResultDto {

    private LottoRankMatcher lottoNumberMatcher;
    private double profit;
    private Map<Rank, Integer> rankIntegerMatcher;

    public LottoResultDto(LottoRankMatcher lottoNumberMatcher, double profit, Map<Rank, Integer> rankIntegerMatcher) {
        this.lottoNumberMatcher=lottoNumberMatcher;
        this.profit=profit;
        this.rankIntegerMatcher = rankIntegerMatcher;
    }


    public LottoRankMatcher getLottoNumberMatcher() {
        return lottoNumberMatcher;
    }

    public double getProfit() {
        return profit;
    }

    public Map<Rank, Integer> getRankIntegerMatcher() {
        return rankIntegerMatcher;
    }

}
