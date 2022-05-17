package lottoauto.util;

import lottoauto.service.LottoTicket;
import lottoauto.wrapper.LottoCount;
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
        if (compareTickets(lottoTicket.get(indexKey)) == LottoCount.FIRST.getValue()) {
            winnerMap.put(LottoCount.FIRST.getValue(), winnerMap.get(LottoCount.FIRST.getValue()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == LottoCount.SECOND.getValue()) {
            winnerMap.put(LottoCount.SECOND.getValue(), winnerMap.get(LottoCount.SECOND.getValue()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == LottoCount.THIRD.getValue()) {
            winnerMap.put(LottoCount.THIRD.getValue(), winnerMap.get(LottoCount.THIRD.getValue()) + 1);
        }

        if (compareTickets(lottoTicket.get(indexKey)) == LottoCount.FOURTH.getValue()) {
            winnerMap.put(LottoCount.FOURTH.getValue(), winnerMap.get(LottoCount.FOURTH.getValue()) + 1);
        }
    }
}
