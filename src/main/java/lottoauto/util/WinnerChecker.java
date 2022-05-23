package lottoauto.util;

import lottoauto.service.LottoTicket;
import lottoauto.wrapper.Lotto;

import java.util.Map;

public class WinnerChecker {
    LottoTicket lottoTicket;

    public WinnerChecker(LottoTicket lottoTicket, Lotto winnerLotto) {
        this.lottoTicket = lottoTicket;
        lottoTicket.getWinnerLotto(winnerLotto);
    }

    public void makeWinnerMap(Map<Integer, Integer> winnerMap) {
        for (int indexKey = 0; indexKey < lottoTicket.size(); indexKey++) {
            addWinnerMapValueByKey(winnerMap, indexKey);
        }
    }

    private void addWinnerMapValueByKey(Map<Integer, Integer> winnerMap, int indexKey) {
        Lotto compareLotto = lottoTicket.get(indexKey);

        matchedCountCheck(matchedCount(compareLotto, Rank.FIRST), winnerMap, Rank.FIRST);
        matchedCountCheck(matchedCount(compareLotto, Rank.SECOND) && lottoTicket.compareBonusTickets(compareLotto), winnerMap, Rank.SECOND);
        matchedCountCheck(matchedCount(compareLotto, Rank.THIRD) && !lottoTicket.compareBonusTickets(compareLotto), winnerMap, Rank.THIRD);
        matchedCountCheck(matchedCount(compareLotto, Rank.FOURTH), winnerMap, Rank.FOURTH);
        matchedCountCheck(matchedCount(compareLotto, Rank.FIFTH), winnerMap, Rank.FIFTH);
    }


    private void matchedCountCheck(boolean compareLotto, Map<Integer, Integer> winnerMap, Rank rank) {
        if (compareLotto) {
            winnerMap.put(rank.getLottoRank(), winnerMap.get(rank.getLottoRank()) + 1);
        }
    }

    private boolean matchedCount(Lotto compareLotto, Rank rank) {
        return lottoTicket.compareTickets(compareLotto) == rank.getCountOfMatch();
    }
}
