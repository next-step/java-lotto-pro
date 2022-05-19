package lotto.domain;

import java.util.List;

public class LottoStatistics {

    private LottoStatistics() {
    }

    public static int matchCount(List<Integer> matchList, LottoRank lottoRank) {
        int count = 0;
        for (int match : matchList) {
            count += lottoRank.isMatch(match) ? 1 : 0;
        }
        return count;
    }

    public static int lottoProfit(List<Integer> matchList, List<LottoRank> lottoRanks) {
        int profit = 0;
        for (LottoRank lottoRank : lottoRanks) {
            int matchCount = matchCount(matchList, lottoRank);
            profit += (matchCount * lottoRank.getPrize());
        }
        return profit;
    }
}
