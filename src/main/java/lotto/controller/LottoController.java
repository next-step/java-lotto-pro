package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningResults;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        Money money = inputView.enterMoney();
        if (!money.isBuyableMoney()) {
            resultView.printLowerThanMinPrice();
            return;
        }
        resultView.printBuyMessage(money);
        
        int manualBuyQuantity = inputView.enterManualBuyQuantity(money);
        
        Lottos lottos = new Lottos(money);
        resultView.printLottoList(lottos);
        lottos.execute(inputView.enterWinningLotto());
        
        WinningResults results = new WinningResults(lottos);
        resultView.printWinningResults(results);
        resultView.printWinningRewardPercent(results.calculateRewardPercent(money));

    }

}
