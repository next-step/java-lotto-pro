package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;

import java.util.List;

import static lotto.domain.LottoPassive.splitPassiveNumber;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoMain {

    public static void main(String[] args) {
        Money money = new Money(inputMoney());
        int gameCount = Lotto.gameCount(money);
        LottoPassiveCount lottoPassiveCount = new LottoPassiveCount(gameCount, passiveCountString());
        LottoPassiveNumbers lottoPassiveNumbers = new LottoPassiveNumbers(lottoPassiveCount);
        String[] lottoPassive = lottoPassiveCount.getPassiveCount() > 0
                ? splitPassiveNumber(inputPassiveNumbersString())
                : new String[0];

        LottoController lottoController = new LottoController(gameCount, lottoPassiveNumbers.generatePassiveNumbers(lottoPassive));
        List<LottoNumbers> lottoNumbers = lottoController.generateLottoGame();
        LottoWiningNumbers lottoWiningNumbers = lottoController.generateLottoWiningNumbers();
        BonusBall bonusBall = lottoController.generateBonusBall();

        LottoRanks lottoRanks = lottoController.gamePlay(lottoNumbers, lottoWiningNumbers, bonusBall);

        lottoGameResultMessage(lottoRanks);
        lottoGameStatisticsMessage(money.lottoGameEarningsRate(lottoRanks));
    }
}
