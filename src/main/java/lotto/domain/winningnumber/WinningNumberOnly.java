package lotto.domain.winningnumber;

import java.util.Iterator;
import java.util.Set;
import lotto.domain.winningnumber.bonus.factory.WinningNumberWithBonusFactory;
import lotto.domain.winningnumber.role.CommaSplitter;
import lotto.domain.winningnumber.role.WinningNumberRole;

public class WinningNumberOnly implements WinningNumber {

    private static final int DEFAULT_MATCH_NUMBER = 0;
    private Set<Integer> winningNumber;

    public WinningNumberOnly(String winningNumber) {
        this.winningNumber = createWinningNumber(winningNumber, new CommaSplitter());
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
    public WinningNumber createWinningNumberWithBonus(String bonus) {
        return new WinningNumberWithBonusFactory(this.winningNumber).createWinningNumberWithBonus(bonus);
    }

    private Set<Integer> createWinningNumber(String winningNumber, WinningNumberRole role) {
        return role.createWinningNumber(winningNumber);
    }

    private int isContainsWinningNumberThenAddMatchNumber(Iterator<Integer> lottoNumberIterator, int matchNumber) {
        if (winningNumber.contains(lottoNumberIterator.next())) {
            matchNumber++;
        }
        return matchNumber;
    }
}
