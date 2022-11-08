package lotto.ui.dto;

import java.util.List;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.WinningNumbers;

public class WinningNumbersInput {
    private final List<Integer> winningNumbers;
    private final int bonus;

    public WinningNumbersInput(List<Integer> winningNumbers, int bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public WinningNumbers toWinningNumbers() {
        final LottoNumbers winningNumbers = new LottoNumbers(this.winningNumbers);
        final LottoNumber bonus = new LottoNumber(this.bonus);

        return new WinningNumbers(winningNumbers, bonus);
    }
}
