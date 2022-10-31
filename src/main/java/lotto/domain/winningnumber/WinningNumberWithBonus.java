package lotto.domain.winningnumber;

import java.util.Iterator;
import java.util.List;

public class WinningNumberWithBonus implements WinningNumber {

    private static final int DEFAULT_MATCH_NUMBER = 0;
    private List<Integer> winningNumberWithBonus;

    public WinningNumberWithBonus(List<Integer> winningNumberWithBonus) {
        this.winningNumberWithBonus = winningNumberWithBonus;
    }

    @Override
    public int matchNumber(Iterator<Integer> lottoNumberIterator) {
        int matchNumber = DEFAULT_MATCH_NUMBER;
        while (lottoNumberIterator.hasNext()) {
            matchNumber = isContainsWinningNumberThenAddMatchNumber(lottoNumberIterator, matchNumber);
        }
        return matchNumber;
    }

    @Override
    public boolean isMatchBonus(Iterator<Integer> lottoNumberIterator) {
        Integer bonus = winningNumberWithBonus.get(winningNumberWithBonus.size() - 1);
        boolean result = false;
        while (lottoNumberIterator.hasNext() && !result) {
            result = isContainsBonus(lottoNumberIterator, bonus, result);
        }
        return result;
    }

    private boolean isContainsBonus(Iterator<Integer> lottoNumberIterator, Integer bonus, boolean result) {
        if (lottoNumberIterator.next().equals(bonus)) {
            result = true;
        }
        return result;
    }

    private int isContainsWinningNumberThenAddMatchNumber(Iterator<Integer> lottoNumberIterator, int matchNumber) {
        if (winningNumberWithBonus.contains(lottoNumberIterator.next())) {
            matchNumber++;
        }
        return matchNumber;
    }
}
