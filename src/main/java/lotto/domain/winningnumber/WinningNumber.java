package lotto.domain.winningnumber;

import java.util.Iterator;

public abstract class WinningNumber {

    private static final String ERROR_UNSUPPORTED_MESSAGE = "[ERROR] 지원하지 않는 기능입니다.";

    abstract public int matchNumber(Iterator<Integer> lottoNumberIterator);

    abstract public boolean isMatchBonus(Iterator<Integer> lottoNumberIterator);

    abstract int isContainsWinningNumberThenAddMatchNumber(Iterator<Integer> lottoNumberIterator, int matchNumber);

    public WinningNumber createWinningNumberWithBonus(String bonus) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_MESSAGE);
    }
}
