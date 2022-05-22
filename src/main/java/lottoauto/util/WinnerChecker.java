package lottoauto.util;

import lottoauto.service.LottoTicket;
import lottoauto.wrapper.Lotto;

import java.util.Map;

public class WinnerChecker {
    private Lotto winnerLotto;

    public WinnerChecker(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    @Override
    public String toString() {
        return winnerLotto.toString();
    }

    private int compareTickets(Lotto compareLotto) {
        return winnerLotto.compare(compareLotto.toList());
    }

    public void makeWinnerMap(LottoTicket lottoTicket, Map<Integer, Integer> winnerMap) {
        for (int indexKey = 0; indexKey < lottoTicket.size(); indexKey++) {
            addWinnerMapValueByKey(lottoTicket, winnerMap, indexKey);
        }
    }

    private void addWinnerMapValueByKey(LottoTicket lottoTicket, Map<Integer, Integer> winnerMap, int indexKey) {
        if (compareTickets(lottoTicket.get(indexKey)) == Rank.FIRST.getLottoRank()) {
            winnerMap.put(Rank.FIRST.getLottoRank(), winnerMap.get(Rank.FIRST.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.SECOND.getLottoRank()) {
            winnerMap.put(Rank.SECOND.getLottoRank(), winnerMap.get(Rank.SECOND.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.THIRD.getLottoRank()) {
            winnerMap.put(Rank.THIRD.getLottoRank(), winnerMap.get(Rank.THIRD.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.FOURTH.getLottoRank()) {
            winnerMap.put(Rank.FOURTH.getLottoRank(), winnerMap.get(Rank.FOURTH.getLottoRank()) + 1);
        }
    }
}
