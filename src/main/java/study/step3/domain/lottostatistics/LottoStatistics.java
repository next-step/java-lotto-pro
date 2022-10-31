package study.step3.domain.lottostatistics;

import study.step3.domain.lotto.LottoRank;
import study.step3.domain.lotto.Money;
import study.step3.domain.lotto.PurchaseMoney;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class LottoStatistics {

    private static final int WINNING_DIVIDE_PURCHASE_MONEY_SCALE = 2;
    private final PurchaseMoney purchaseMoney;
    private final List<Long> matchCounts;
    private final LottoRankCountCache rankCountCache;

    public LottoStatistics(PurchaseMoney purchaseMoney, final List<Long> matchCounts) {
        this.purchaseMoney = purchaseMoney;
        this.matchCounts = filterHasWinningsRank(matchCounts);
        this.rankCountCache = mapToRankCountCache();
    }

    private List<Long> filterHasWinningsRank(List<Long> matchCounts) {
        return matchCounts.stream()
                .filter(isGreaterThanOrEqualMatchCount(LottoRank.minimumLottoRank()))
                .collect(Collectors.toList());
    }

    private Predicate<Long> isGreaterThanOrEqualMatchCount(LottoRank lottoRank) {
        return matchCount -> matchCount >= lottoRank.matchCount();
    }

    private LottoRankCountCache mapToRankCountCache() {
        Map<LottoRank, Long> lottoRankCountCache = this.matchCounts.stream()
                .map(LottoRank::ofMatchCount)
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
        return new LottoRankCountCache(lottoRankCountCache);
    }

    public long findLottoRankCount(LottoRank lottoRank) {
        return rankCountCache.count(lottoRank);
    }

    public LottoRateOfReturn calculateRateOfReturn() {
        Money winningMoney = rankCountCache.sumWinningMoney();
        double rateOfReturn = BigDecimal.valueOf(winningMoney.money())
                .divide(BigDecimal.valueOf(purchaseMoney.money()), WINNING_DIVIDE_PURCHASE_MONEY_SCALE, RoundingMode.DOWN)
                .doubleValue();
        return new LottoRateOfReturn(rateOfReturn);
    }
}
