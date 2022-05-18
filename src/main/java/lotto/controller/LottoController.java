package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.domain.LottoPassive.splitPassiveNumber;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoController {
    private final LottoGameCount lottoGameCount;

    public LottoController(LottoGameCount lottoGameCount) {
        this.lottoGameCount = lottoGameCount;
    }

    public List<LottoNumbers> generatePassiveNumbers() {
        String[] lottoPassive = lottoGameCount.getPassiveCount() > 0
                ? splitPassiveNumber(inputPassiveNumbersString())
                : new String[0];

        return new LottoPassiveNumbers(lottoGameCount).generatePassiveNumbers(lottoPassive);
    }

    public List<LottoNumbers> generateLottoGame(List<LottoNumbers> lottoPassiveNumbers) {
        purchasesCountMessage(lottoGameCount.getGameCount());
        List<LottoNumbers> lottoNumbers = Lotto.generateLottoGame(lottoGameCount.getGameCount(), lottoPassiveNumbers);
        resultGameCount(lottoGameCount.getGameCount(), lottoPassiveNumbers.size());
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
