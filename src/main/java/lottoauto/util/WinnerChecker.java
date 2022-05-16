package lottoauto.util;

import lottoauto.wrapper.Lotto;

import java.util.Collections;

public class WinnerChecker {
    private Lotto winnerLotto;
    public WinnerChecker(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    @Override
    public String toString() {
        return winnerLotto.toString();
    }

    public int compareTickets(Lotto compareLotto) {

        return winnerLotto.compare(compareLotto.toList());
    }

}
