package lotto.domain.winningnumber;

import java.util.Iterator;
import java.util.List;

public class WinningNumberWithBonus implements WinningNumber {

    private List<Integer> winningNumberWithBonus;

    public WinningNumberWithBonus(List<Integer> winningNumberWithBonus) {
        this.winningNumberWithBonus = winningNumberWithBonus;
    }

    @Override
    public int matchNumber(Iterator<Integer> lottoNumberIterator) {
        return 0;
    }
}
