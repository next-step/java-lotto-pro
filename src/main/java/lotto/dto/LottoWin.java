package lotto.dto;

import lotto.MatchPrizes;
import lotto.WinningNumbers;

public final class LottoWin {

    private final WinningNumbers winningNumbers;
    private final MatchPrizes matchPrizes;

    public LottoWin(WinningNumbers winningNumbers, MatchPrizes matchPrizes) {
        this.winningNumbers = winningNumbers;
        this.matchPrizes = matchPrizes;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public MatchPrizes getMatchPrizes() {
        return matchPrizes;
    }
}
