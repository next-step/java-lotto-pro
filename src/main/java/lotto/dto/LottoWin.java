package lotto.dto;

import lotto.Match;
import lotto.WinningNumbers;

import java.util.Map;

public final class LottoWin {

    private final WinningNumbers winningNumbers;
    private final Map<Match, Integer> prizeMoneyByMatch;

    public LottoWin(WinningNumbers winningNumbers, Map<Match, Integer> prizeMoneyByMatch) {
        this.winningNumbers = winningNumbers;
        this.prizeMoneyByMatch = prizeMoneyByMatch;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public Map<Match, Integer> getPrizeMoneyByMatch() {
        return prizeMoneyByMatch;
    }
}
