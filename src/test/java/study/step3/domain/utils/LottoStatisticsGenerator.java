package study.step3.domain.utils;

import study.step3.domain.lotto.LottoRank;
import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lottostatistics.LottoRankCountCache;
import study.step3.domain.lottostatistics.LottoStatistics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStatisticsGenerator {
    public static LottoStatistics createLottoStatistics(long rankCount, LottoRank lottoRank, long purchaseMoney) {
        List<Long> matchCounts = LongStream.range(0, rankCount)
                .map(i -> lottoRank.matchCount())
                .boxed()
                .collect(Collectors.toList());
        return new LottoStatistics(PurchaseMoney.of(purchaseMoney), LottoRankCountCache.of(matchCounts));
    }
}
