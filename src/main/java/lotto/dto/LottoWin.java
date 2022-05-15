package lotto.dto;

import lotto.LottoNumber;
import lotto.Match;

import java.util.List;
import java.util.Map;

public final class LottoWin {

    private final List<LottoNumber> winningNumbers;
    private final Map<Match, Integer> prizeMoneyByMatch;

    public LottoWin(List<LottoNumber> winningNumbers, Map<Match, Integer> prizeMoneyByMatch) {
        this.winningNumbers = winningNumbers;
        this.prizeMoneyByMatch = prizeMoneyByMatch;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public Map<Match, Integer> getPrizeMoneyByMatch() {
        return prizeMoneyByMatch;
    }
}
