package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.view.InputView.bonusNumberString;
import static lotto.view.InputView.lastWeekWinningNumberString;
import static lotto.view.ResultView.purchasesCountMessage;
import static lotto.view.ResultView.resultLottoNumbers;

public class LottoController {
    private final int gameCount;

    public LottoController(int gameCount) {
        this.gameCount = gameCount;
    }

    public List<LottoNumbers> generateLottoGame() {
        purchasesCountMessage(gameCount);
        List<LottoNumbers> lottoNumbers = Lotto.generateLottoGame(gameCount);
        resultLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    public LottoWiningNumbers generateLottoWiningNumbers() {
        return new LottoWiningNumbers(lastWeekWinningNumberString());
    }

    public BonusBall generateBonusBall() {
        return new BonusBall(bonusNumberString());
    }

    public LottoRanks gamePlay(
            List<LottoNumbers> lottoNumbers,
            LottoWiningNumbers lottoWiningNumbers,
            BonusBall bonusBall
    ) {
        Lotto lotto = new Lotto(lottoNumbers);

        return new LottoRanks(lotto.gamePlay(lottoWiningNumbers.generate(), bonusBall));
    }
}
