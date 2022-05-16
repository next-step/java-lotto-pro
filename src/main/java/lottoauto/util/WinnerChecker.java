package lottoauto.util;

import lottoauto.service.LottoTicket;
import lottoauto.wrapper.Lotto;

import java.util.Collections;
import java.util.Map;

public class WinnerChecker {
    private Lotto winnerLotto;
    private static final int FOURTH = 3;
    private static final int THIRD = 4;
    private static final int SECOND = 5;
    private static final int FIRST = 6;
    private static final int WIN_LIST = 4;

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
        for (int i = 0; i < lottoTicket.size(); i++) {
            if (compareTickets(lottoTicket.get(i)) == FIRST) {
                winnerMap.put(FIRST, winnerMap.get(FIRST) + 1);
            }

            if (compareTickets(lottoTicket.get(i)) == SECOND) {
                winnerMap.put(SECOND, winnerMap.get(SECOND) + 1);
            }

            if (compareTickets(lottoTicket.get(i)) == THIRD) {
                winnerMap.put(THIRD, winnerMap.get(THIRD) + 1);
            }

            if (compareTickets(lottoTicket.get(i)) == FOURTH) {
                winnerMap.put(FOURTH, winnerMap.get(FOURTH) + 1);
            }

        }
    }
}
