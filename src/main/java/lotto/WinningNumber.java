package lotto;

import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> winningNumber;

    public WinningNumber(List<LottoNumber> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int winningCount(Lotto lotto) {
        return (int) winningNumber.stream()
                .filter(lotto::contains).count();
    }
}
