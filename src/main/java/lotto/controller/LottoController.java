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

		IssueQuantity issueQuantity = inputView.enterManualQuantity(money);
		Lottos lottos = new Lottos(issueQuantity, inputView.enterManualNumbers(issueQuantity.getManualQuantity()));
		resultView.printBuyMessage(issueQuantity);
		resultView.printLottoList(lottos);
		lottos.execute(inputView.enterWinningLotto());

		WinningResults results = new WinningResults(lottos);
		resultView.printWinningResults(results);
		resultView.printWinningRewardPercent(results.calculateRewardPercent(money));
	}

}
