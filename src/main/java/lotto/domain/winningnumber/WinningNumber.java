package lotto.domain.winningnumber;

import java.util.Iterator;

public interface WinningNumber {

    int matchNumber(Iterator<Integer> lottoNumberIterator);

    boolean isMatchBonus(Iterator<Integer> lottoNumberIterator);

    default WinningNumber createWinningNumberWithBonus(String bonus) {
        throw new UnsupportedOperationException("[ERROR] 지원하지 않는 기능입니다.");
    }
}
