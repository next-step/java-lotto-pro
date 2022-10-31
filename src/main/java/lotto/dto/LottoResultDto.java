package lotto.dto;

import lotto.domain.LottoNumberMatcher;

import java.util.Map;

public class LottoResultDto {

    private Map<Integer,Integer> winningPriceMap;
    private LottoNumberMatcher lottoNumberMatcher;
    private double profit;

    public LottoResultDto(Map<Integer, Integer> winningPriceMap, LottoNumberMatcher lottoNumberMatcher, double profit) {
        this.winningPriceMap=winningPriceMap;
        this.lottoNumberMatcher=lottoNumberMatcher;
        this.profit=profit;
    }

    public Map<Integer, Integer> getWinningPriceMap() {
        return winningPriceMap;
    }

    public LottoNumberMatcher getLottoNumberMatcher() {
        return lottoNumberMatcher;
    }

    public double getProfit() {
        return profit;
    }

}
