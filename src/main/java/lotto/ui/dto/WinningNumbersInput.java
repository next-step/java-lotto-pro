package lotto.ui.dto;

import java.util.List;

public class WinningNumbersInput {
    private final List<Integer> winningNumbers;

    public WinningNumbersInput(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
