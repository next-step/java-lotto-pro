package lotto.domain.winningnumber;

import java.util.Iterator;
import java.util.List;

public class WinningNumberWithBonus extends WinningNumber {

    private static final int DEFAULT_MATCH_NUMBER = 0;
    private static final int BONUS_INDEX = (-1);
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
        Integer bonus = winningNumberWithBonus.get(winningNumberWithBonus.size() + BONUS_INDEX);
        boolean result = false;
        while (lottoNumberIterator.hasNext() && !result) {
            result = isContainsBonus(lottoNumberIterator, bonus, result);
        }
        return result;
    }

    @Override
    int isContainsWinningNumberThenAddMatchNumber(Iterator<Integer> lottoNumberIterator, int matchNumber) {
        if (winningNumberWithBonus.contains(lottoNumberIterator.next())) {
            matchNumber++;
        }
        return matchNumber;
    }

    private boolean isContainsBonus(Iterator<Integer> lottoNumberIterator, Integer bonus, boolean result) {
        if (lottoNumberIterator.next().equals(bonus)) {
            result = true;
        }
        return result;
    }
}
