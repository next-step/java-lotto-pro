package lotto.domain;

import java.util.Map;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class StatisticsGenerator {

    public static StatisticsResult create(final LottoTicket lottoTicket, final WinningLotto winninglotto) {
        Ranks ranks = mapToRanks(winninglotto, lottoTicket);
        return new StatisticsResult(ranks.getCountsOfRanks(), calculateYields(ranks, lottoTicket.getCount()));
    }

    private static Ranks mapToRanks(final WinningLotto winninglotto, final LottoTicket lottoTicket) {
        return lottoTicket.check(new Ranks(), winninglotto);
    }

    private static Double calculateYields(final Ranks ranks, final int countOfLotto) {
        double totalWinnerAmount = 0;
        Map<Rank, Integer> countsOfRanks = ranks.getCountsOfRanks();
        for(Map.Entry<Rank, Integer> rankToCount: countsOfRanks.entrySet()) {
            totalWinnerAmount += rankToCount.getKey().getWinningMoney() * rankToCount.getValue();
        }
        double investmentAmount = countOfLotto * LOTTO_PRICE;
        return totalWinnerAmount / investmentAmount;
    }
}
