package study.step3.domain.lottostatistics;

import study.step3.domain.lotto.LottoRank;
import study.step3.domain.lotto.Money;
import study.step3.domain.lottonumber.LottoMatchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class LottoRankCountCache {
    private final Map<LottoRank, Long> rankCountCache;

    public LottoRankCountCache(Map<LottoRank, Long> rankCountCache) {
        this.rankCountCache = new HashMap<>(rankCountCache);
    }

    public static LottoRankCountCache of(List<LottoMatchResult> matchCounts) {
        Map<LottoRank, Long> lottoRankCountCache = matchCounts.stream()
                .filter(isGreaterThanOrEqualMatchCount(LottoRank.minimumLottoRank()))
                .map(LottoRank::ofMatchResult)
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
        return new LottoRankCountCache(lottoRankCountCache);
    }

    private static Predicate<LottoMatchResult> isGreaterThanOrEqualMatchCount(LottoRank lottoRank) {
        return matchResult -> matchResult.isGreaterThanOrEqualMatchCount(lottoRank.matchResult());
    }

    public Long count(LottoRank lottoRank) {
        Long count = this.rankCountCache.get(lottoRank);
        if(count == null) {
            return 0L;
        }
        return count;
    }

    public Money sumWinningMoney() {
        return this.rankCountCache.entrySet().stream()
                .map(cache -> {
                    LottoRank rank = cache.getKey();
                    Long count = cache.getValue();
                    return rank.winningMoneyWithCount(count);
                })
                .reduce(Money::plus)
                .orElse(Money.zero());
    }
}
