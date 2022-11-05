package lotto.ui.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class WinningNumbersInput {
    private final List<Integer> winningNumbers;

    public WinningNumbersInput(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Lotto toWinningNumbers() {
        return new Lotto(winningNumbers);
    }
}
