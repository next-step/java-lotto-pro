package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinnerNumbers {
    private List<Integer> winnerNumbers;
    private BonusBall bonusBall;

    public LottoWinnerNumbers(List<Integer> winnerNumbers, BonusBall bonusBall) {
        this.winnerNumbers = winnerNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public Integer getBonusBall() {
        return bonusBall.value();
    }

    public List<LottoWinner> calculateLottoResults(Lottos lottos) {
        List<LottoWinner> lottoResults = new ArrayList<>();
        for (int i = 0; i < lottos.gameCount(); i++) {
            LottoWinner judge = lottos.getLotto(i).judge(winnerNumbers, bonusBall.value());
            lottoResults.add(judge);
        }
        return lottoResults;
    }
}
