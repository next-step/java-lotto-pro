package lotto.domain;

import java.util.List;
import java.util.Map;

import static lotto.domain.Lotto.LottoPrice;

public class StatisticsGenerator {

    public static StatisticsResult create(final LottoTicket lottoTicket, final WinningLotto winninglotto) {
        List<Lotto> lottoList = lottoTicket.getLottoList();
        Ranks ranks = mapToRanks(winninglotto, lottoList);
        return new StatisticsResult(ranks.getCountsOfRanks(), calculateYields(ranks, lottoList.size()));
    }

    private static Ranks mapToRanks(final WinningLotto winninglotto, final List<Lotto> lottoList) {
        Ranks ranks = new Ranks();
        for(Lotto lotto : lottoList) {
            Rank rank = Rank.valueOf(calculateMatchCount(lotto, winninglotto));
            ranks.add(rank);
        }
        return ranks;
    }

    private static Double calculateYields(final Ranks ranks, final int countOfLotto) {
        double totalWinnerAmount = 0;
        Map<Rank, Integer> countsOfRanks = ranks.getCountsOfRanks();
        for(Map.Entry<Rank, Integer> rankToCount: countsOfRanks.entrySet()) {
            totalWinnerAmount += rankToCount.getKey().getWinningMoney() * rankToCount.getValue();
        }
        double investmentAmount = countOfLotto * LottoPrice;
        return totalWinnerAmount / investmentAmount;
    }

    private static int calculateMatchCount(final Lotto lotto, final WinningLotto winninglotto) {
        int matchCount = 0;
        for(LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            matchCount += getOffset(winninglotto, lottoNumber);
        }
        return matchCount;
    }

    private static int getOffset(final WinningLotto winninglotto, final LottoNumber lottoNumber) {
        if(winninglotto.getLottoNumbers().contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
