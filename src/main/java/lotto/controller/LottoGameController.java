package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {
    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Money money = inputView.inputMoney();
        LottoGame lottoGame = LottoStore.sell(money);

        resultView.printLottoTryCount(lottoGame);
        resultView.printLottoBalls(lottoGame);
    }
}
