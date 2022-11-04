package lotto.winning.domain;

import com.sun.tools.javac.util.List;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.Lottos;

public class WinningNumber {

    private List<Lotto> winningNumbers;

    public void addAll(List<Lotto> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int matchCounts(Lottos lottos) {
        int matchCounts = 0;
        for (Lotto lotto : lottos.getLottos()) {
            matchCounts = plusMatchCounts(matchCounts, lotto);
        }
        return matchCounts;
    }

    private int plusMatchCounts(int matchCounts, Lotto lotto) {
        for (Lotto winningNumber : this.winningNumbers) {
            matchCounts = plusMatchCount(matchCounts, lotto, winningNumber);
        }
        return matchCounts;
    }

    private static int plusMatchCount(int matchCounts, Lotto lotto, Lotto winningNumber) {
        if (lotto.equals(winningNumber)) {
            matchCounts++;
        }
        return matchCounts;
    }
}
