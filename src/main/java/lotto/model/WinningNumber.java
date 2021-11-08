package lotto.model;

import java.util.List;

public class WinningNumber {
    private final Lotto winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
    }

    public int winningCount(Lotto lotto) {
        return (int) winningNumber.getLotto().stream()
                .filter(lotto::contains).count();
    }
}
