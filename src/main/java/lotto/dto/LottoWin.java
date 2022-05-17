package lotto.dto;

import lotto.domain.WinningNumbers;

public final class LottoWin {

    private final WinningNumbers winningNumbers;

    public LottoWin(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
