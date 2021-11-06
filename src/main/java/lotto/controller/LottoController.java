package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        Money money = inputView.enterMoney();
        resultView.printBuyMessage(money.buyableQuantity());
        Lottos lottos = new Lottos(money.buyableQuantity());
        resultView.printLottoList(lottos);
        lottos.countWinningRank(inputView.enterWinningLotto());
        resultView.printWinningStatistics(new WinningStatistics(lottos));

    }

}
