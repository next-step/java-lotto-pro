package lotto.domain;

import lotto.domain.common.Constant;
import lotto.enums.Ranking;

import java.util.EnumMap;
import java.util.List;

public class WinningStatistics {

    private final EnumMap<Ranking, Integer> winningStatisticsResult;

    private WinningStatistics(EnumMap<Ranking, Integer> winningStatisticsResult) {
        this.winningStatisticsResult = winningStatisticsResult;
    }

    public static WinningStatistics statistics(final WinningLotto winningLotto, final Lottos lottos)  {
        EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }

        List<MatchResult> matchingCounts = lottos.getMatchingCounts(winningLotto);

        for(MatchResult matchingCount : matchingCounts) {

            Ranking findRanking = Ranking.findCorrect(matchingCount);
            result.put(findRanking, result.getOrDefault(findRanking, 0) + 1);
        }

        return new WinningStatistics(result);
    }

    public double calculatePrizeMoney() {
        int totalPrize = 0;
        int lottoCount = 0;

        for (Ranking ranking : winningStatisticsResult.keySet()) {
            totalPrize += ranking.totalWinningMoney(winningStatisticsResult.get(ranking));
            lottoCount += winningStatisticsResult.get(ranking);
        }

        return (double) totalPrize / (lottoCount * Constant.LOTTO_PURCHASE_PRICE);
    }

    public int getRankHitsCount(final Ranking ranking) {
        return winningStatisticsResult.get(ranking);
    }
}
