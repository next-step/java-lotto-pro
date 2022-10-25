package lotto.domain;

import java.util.List;
import java.util.Map;

public class StatisticsGenerator {

    public static StatisticsResult create(final LottoTicket lottoTicket, final WinnerLotto winnerLotto) {
        List<Lotto> lottoList = lottoTicket.getLottoList();
        Ranks ranks = mapToRanks(winnerLotto, lottoList);
        return new StatisticsResult(ranks.getCountsOfRanks(), calculateProfit(ranks, lottoList.size()));
    }

    private static Ranks mapToRanks(final WinnerLotto winnerLotto, final List<Lotto> lottoList) {
        Ranks ranks = new Ranks();
        for(Lotto lotto : lottoList) {
            Rank rank = Rank.valueOf(calculateMatchCount(lotto, winnerLotto));
            ranks.add(rank);
        }
        return ranks;
    }

    private static Double calculateProfit(final Ranks ranks, final int countOfLotto) {
        double totalWinnerAmount = 0;
        Map<Rank, Integer> countsOfRanks = ranks.getCountsOfRanks();
        for(Map.Entry<Rank, Integer> rankToCount: countsOfRanks.entrySet()) {
            totalWinnerAmount += rankToCount.getKey().getWinningMoney() * rankToCount.getValue();
        }
        double investmentAmount = countOfLotto * 1000;
        return totalWinnerAmount / investmentAmount;
    }

    private static int calculateMatchCount(final Lotto lotto, final WinnerLotto winnerLotto) {
        int matchCount = 0;
        for(LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            matchCount += getOffset(winnerLotto, lottoNumber);
        }
        return matchCount;
    }

    private static int getOffset(final WinnerLotto winnerLotto, final LottoNumber lottoNumber) {
        if(winnerLotto.getLottoNumbers().contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
