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

    private boolean compareBonusTickets(Lotto compareLotto) {
        return winnerLotto.compareBonus(compareLotto.getBonusNumber());
    }

    public void makeWinnerMap(LottoTicket lottoTicket, Map<Integer, Integer> winnerMap) {
        for (int indexKey = 0; indexKey < lottoTicket.size(); indexKey++) {
            addWinnerMapValueByKey(lottoTicket, winnerMap, indexKey);
        }
    }

    private void addWinnerMapValueByKey(LottoTicket lottoTicket, Map<Integer, Integer> winnerMap, int indexKey) {
        if (compareTickets(lottoTicket.get(indexKey)) == Rank.FIRST.getCountOfMatch()) {
            winnerMap.put(Rank.FIRST.getLottoRank(), winnerMap.get(Rank.FIRST.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.SECOND.getCountOfMatch() && compareBonusTickets(lottoTicket.get(indexKey))) {
            winnerMap.put(Rank.SECOND.getLottoRank(), winnerMap.get(Rank.SECOND.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.THIRD.getCountOfMatch() && !compareBonusTickets(lottoTicket.get(indexKey))) {
            winnerMap.put(Rank.THIRD.getLottoRank(), winnerMap.get(Rank.THIRD.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.FOURTH.getCountOfMatch()) {
            winnerMap.put(Rank.FOURTH.getLottoRank(), winnerMap.get(Rank.FOURTH.getLottoRank()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == Rank.FIFTH.getCountOfMatch()) {
            winnerMap.put(Rank.FIFTH.getLottoRank(), winnerMap.get(Rank.FIFTH.getLottoRank()) + 1);
        }
    }
}
