package study.step3.domain.lottostatistics;

import study.step3.domain.lotto.LottoRank;
import study.step3.domain.lotto.Money;

import java.util.HashMap;
import java.util.Map;

public class LottoRankCountCache {
    private final Map<LottoRank, Long> rankCountCache;

    public LottoRankCountCache(Map<LottoRank, Long> rankCountCache) {
        this.rankCountCache = new HashMap<>(rankCountCache);
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
