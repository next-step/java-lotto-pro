package study.step3.domain.lottostatistics;

import study.step3.domain.lotto.LottoRank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class LottoStatistics {

    private final long purchaseMoney;
    private final List<Long> matchCounts;
    private final Map<LottoRank, Long> rankCountCache;

    public LottoStatistics(final long purchaseMoney, final List<Long> matchCounts) {
        this.purchaseMoney = purchaseMoney;
        this.matchCounts = filterHasWinningsRank(matchCounts);
        this.rankCountCache = initRankCountCache();
    }

    private List<Long> filterHasWinningsRank(List<Long> matchCounts) {
        return matchCounts.stream()
                .filter(isGreaterThanOrEqualMatchCount(LottoRank.minimumLottoRank()))
                .collect(Collectors.toList());
    }

    private Predicate<Long> isGreaterThanOrEqualMatchCount(LottoRank lottoRank) {
        return matchCount -> matchCount >= lottoRank.matchCount();
    }

    private Map<LottoRank, Long> initRankCountCache() {
        return this.matchCounts.stream()
                .map(LottoRank::ofMatchCount)
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
    }

    public long findLottoLankCount(LottoRank lottoRank) {
        Long count = rankCountCache.get(lottoRank);
        if(count == null) {
            return 0L;
        }

        return count;
    }

    public double calculateRateOfReturn() {
        BigDecimal sumWinnings = BigDecimal.valueOf(sumWinnings());
        if(sumWinnings.equals(BigDecimal.ZERO)) {
            return 0.0;
        }

        return sumWinnings
                .divide(BigDecimal.valueOf(this.purchaseMoney), 2, RoundingMode.DOWN)
                .doubleValue();
    }

    private long sumWinnings() {
        return this.rankCountCache.entrySet().stream()
                .mapToLong(cache -> {
                    LottoRank rank = cache.getKey();
                    Long count = cache.getValue();
                    return rank.winnings() * count;
                }).sum();
    }
}
