package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;

public final class LottoWin {

    private final WinningNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWin(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
