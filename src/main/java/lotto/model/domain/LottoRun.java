package lotto.model.domain;

import lotto.model.vo.Lotto;
import lotto.model.vo.WinLotto;

public class LottoRun {
    public static int countMatchNumber(WinLotto winLotto, Lotto userLotto) {
        return winLotto.compareWithLotto(userLotto);
    }

    public static double calculateProfit(long buyAmount, long winAmount) {
        return Math.floor(winAmount * 1.0 / buyAmount * 100) / 100.0;
    }
}
