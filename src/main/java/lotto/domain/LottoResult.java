package lotto.domain;

import java.util.NavigableMap;

public class LottoResult {

    private final RankResult rankResult;
    private final RateOfReturn rateOfReturn;

    private LottoResult(RankResult rankResult, RateOfReturn rateOfReturn) {
        this.rankResult = rankResult;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoResult of(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        RankResult rankResult = RankResult.of(lottoTicket, lottoWinningNumbers);
        RateOfReturn rateOfReturn = rankResult.calculateRateOfReturn(lottoPurchase);
        return new LottoResult(rankResult, rateOfReturn);
    }

    public NavigableMap<LottoRank, Long> getRankResult() {
        return rankResult.getRankResult();
    }

    public RateOfReturn getRateOfReturn() {
        return rateOfReturn;
    }

}
