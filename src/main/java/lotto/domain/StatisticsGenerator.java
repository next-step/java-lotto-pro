package lotto.domain;

import java.util.Map;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class StatisticsGenerator {

    public static StatisticsResult create(final LottoTicket lottoTicket, final WinningLotto winninglotto) {
        Ranks ranks = mapToRanks(winninglotto, lottoTicket);
        return new StatisticsResult(ranks.getCountsOfRanks(), calculateYields(ranks, lottoTicket.getLottoCount()));
    }

    private static Ranks mapToRanks(final WinningLotto winninglotto, final LottoTicket lottoTicket) {
        return lottoTicket.check(winninglotto);
    }

    private static Yields calculateYields(final Ranks ranks, final int countOfLotto) {
        double totalWinnerAmount = 0;
        Map<Rank, Integer> countsOfRanks = ranks.getCountsOfRanks();

        for(Map.Entry<Rank, Integer> rankToCount : countsOfRanks.entrySet()) {
            Rank rank = rankToCount.getKey();
            totalWinnerAmount += rank.getWinningMoney() * rankToCount.getValue();
        }

        double investmentAmount = countOfLotto * LOTTO_PRICE;
        if(totalWinnerAmount == 0 && investmentAmount == 0) {
            return new Yields(0);
        }

        return new Yields(totalWinnerAmount / investmentAmount);
    }
}
