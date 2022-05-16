package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;

import java.util.List;

import static lotto.view.InputView.inputMoney;
import static lotto.view.ResultView.*;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(inputMoney());
        int gameCount = Lotto.gameCount(money);

        LottoController lottoController = new LottoController(gameCount);
        List<LottoNumbers> lottoNumbers = lottoController.generateLottoGame();
        LottoWiningNumbers lottoWiningNumbers = lottoController.generateLottoWiningNumbers();
        BonusBall bonusBall = lottoController.generateBonusBall();

        LottoRanks lottoRanks = lottoController.gamePlay(lottoNumbers, lottoWiningNumbers, bonusBall);

        lottoGameResultMessage(lottoRanks);
        lottoGameStatisticsMessage(money.lottoGameEarningsRate(lottoRanks));
    }
}
