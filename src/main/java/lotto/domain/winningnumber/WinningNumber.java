package lotto.domain.winningnumber;

import java.util.Iterator;
import java.util.Set;
import lotto.domain.winningnumber.role.CommaSplitter;
import lotto.domain.winningnumber.role.WinningNumberRole;
import lotto.domain.winningnumber.validation.DefaultWinningNumberValidator;

public class WinningNumber {

    private static final int DEFAULT_MATCH_NUMBER = 0;
    private Set<Integer> winningNumber;

    public WinningNumber(String winningNumber) {
        new DefaultWinningNumberValidator().validate(winningNumber);
        this.winningNumber = createWinningNumber(winningNumber, new CommaSplitter());
    }

    public int matchNumber(Iterator<Integer> lottoNumberIterator) {
        int matchNumber = DEFAULT_MATCH_NUMBER;
        while (lottoNumberIterator.hasNext()) {
            matchNumber = isContainsWinningNumberThenAddMatchNumber(lottoNumberIterator, matchNumber);
        }
        return matchNumber;
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
