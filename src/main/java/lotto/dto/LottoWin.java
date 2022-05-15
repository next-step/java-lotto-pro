package lotto.dto;

import lotto.LottoNumber;

import java.util.List;
import java.util.Map;

public final class LottoWin {

    private final List<LottoNumber> winningNumbers;
    private final Map<Integer, Integer> prizeMoneyByMatch;

    public LottoWin(List<LottoNumber> winningNumbers, Map<Integer, Integer> prizeMoneyByMatch) {
        this.winningNumbers = winningNumbers;
        this.prizeMoneyByMatch = prizeMoneyByMatch;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public Map<Integer, Integer> getPrizeMoneyByMatch() {
        return prizeMoneyByMatch;
    }
}
