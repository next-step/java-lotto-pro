package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {
    public void start() {
        Money money = InputView.inputMoney();
        LottoGame lottoGame = LottoStore.sell(money);

        ResultView.printLottoTryCount(lottoGame);
        ResultView.printLottoBalls(lottoGame);

        LottoBalls winLottoBalls = new LottoBalls(InputView.inputWinNumbers());
        LottoBall bonusBall = InputView.inputBonusNumber();
        WinningBalls winningBalls = new WinningBalls(winLottoBalls, bonusBall);
        Statistics statistics = lottoGame.calculateLottoResult(winningBalls);

        ResultView.printLottoResult(money, statistics);
    }

}
