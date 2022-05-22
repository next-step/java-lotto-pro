package lotto.domain;

import java.util.List;

public class LottoWinnerNumbers {
    private List<Integer> winnerNumbers;
    private Integer bonusBall;

    public LottoWinnerNumbers(List<Integer> winnerNumbers, Integer bonusBall) {
        this.winnerNumbers = winnerNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public Integer getBonusBall() {
        return bonusBall;
    }
}
