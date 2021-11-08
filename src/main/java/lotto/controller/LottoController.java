package lotto.controller;

import lotto.domain.IssueQuantity;
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
        
        int manualQuantity = inputView.enterManualBuyQuantity(money);
        IssueQuantity iq = new IssueQuantity().fromManual(manualQuantity).fromAuto(money.buyableQuantity() - manualQuantity);
        
        Lottos lottos = new Lottos(iq, inputView.enterManualNumbers(manualQuantity));
        resultView.printBuyMessage(iq);
        resultView.printLottoList(lottos);
        lottos.execute(inputView.enterWinningLotto());
        
        WinningResults results = new WinningResults(lottos);
        resultView.printWinningResults(results);
        resultView.printWinningRewardPercent(results.calculateRewardPercent(money));

    }

}
