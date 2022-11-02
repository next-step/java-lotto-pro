package lotto.domain;

import java.util.Map;

public class LottoRankMatcher {

    private Map<Lotto, Rank> lottoNumberMatcher;

    public LottoRankMatcher(Lotteries lotteries, WinningNumbers winningNumbers) {
        this.lottoNumberMatcher = lotteries.getLottoMatchRankMap(winningNumbers);
    }

    public int getMatchLottoRank(Rank rank) {
        return (int) lottoNumberMatcher.keySet().stream()
                .filter(lotto -> lottoNumberMatcher.get(lotto) == rank)
                .count();
    }

}
