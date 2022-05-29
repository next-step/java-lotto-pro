package lotto.domain;

import java.util.ArrayList;
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

    public List<LottoWinner> calculateLottoResults(Lottos lottos) {
        List<LottoWinner> lottoResults = new ArrayList<>();
        for (int i = 0; i < lottos.gameCount(); i++) {
            LottoWinner judge = lottos.getLotto(i).judge(winnerNumbers, bonusBall);
            lottoResults.add(judge);
        }
        return lottoResults;
    }
}
