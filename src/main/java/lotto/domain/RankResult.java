package lotto.domain;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

import static java.util.Arrays.stream;

public class RankResult {

    private final NavigableMap<LottoRank, Long> rankResult;

    private RankResult(NavigableMap<LottoRank, Long> rankResult) {
        this.rankResult = rankResult;
    }

    public static RankResult of(LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        NavigableMap<LottoRank, Long> rankResult = new TreeMap<>();
        stream(LottoRank.values())
                .forEach(lottoRank -> rankResult.put(lottoRank, lottoTicket.countLottoRank(lottoRank, lottoWinningNumbers)));
        return new RankResult(rankResult);
    }

    public RateOfReturn calculateRateOfReturn(LottoPurchase lottoPurchase) {
        int totalPrizeMoney = 0;
        for (NavigableMap.Entry<LottoRank, Long> entry : rankResult.entrySet()) {
            totalPrizeMoney += entry.getKey().calculatePrize(entry.getValue());
        }
        return RateOfReturn.from((double) totalPrizeMoney / lottoPurchase.getPurchaseAmount());
    }

    public NavigableMap<LottoRank, Long> getRankResult() {
        return Collections.unmodifiableNavigableMap(new TreeMap<>(rankResult));
    }

}
