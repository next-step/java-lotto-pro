package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;

import java.util.List;

import static lotto.view.InputView.inputMoney;
import static lotto.view.InputView.passiveCountString;
import static lotto.view.ResultView.lottoGameResultMessage;
import static lotto.view.ResultView.lottoGameStatisticsMessage;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(inputMoney());
        int gameCount = Lotto.gameCount(money);
        LottoGameCount lottoGameCount = new LottoGameCount(gameCount, passiveCountString());

        LottoController lottoController = new LottoController(lottoGameCount);
        List<LottoNumbers> lottoPassiveNumbers = lottoController.generatePassiveNumbers();
        List<LottoNumbers> lottoNumbers = lottoController.generateLottoGame(lottoPassiveNumbers);
        LottoWiningNumbers lottoWiningNumbers = lottoController.generateLottoWiningNumbers();

        BonusBall bonusBall = lottoController.generateBonusBall();

        LottoRanks lottoRanks = lottoController.gamePlay(lottoNumbers, lottoWiningNumbers, bonusBall);

        lottoGameResultMessage(lottoRanks);
        lottoGameStatisticsMessage(money.lottoGameEarningsRate(lottoRanks));
    }
}
