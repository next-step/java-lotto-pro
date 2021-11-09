package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.Store;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Controller {
	private final InputView inputView;
	private final ResultView resultView;

	public Controller(final InputView inputView, final ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void run() {
		int purchaseMoney = inputView.purchaseMoneyAmount();
		int manualLottoCount = inputView.manualLottoCount();
		List<List<Integer>> manualLottoNumbers = inputView.manualLottoNumbers(manualLottoCount);

		Money money = new Money(purchaseMoney);
		Lottos lottos = Store.order(money, manualLottoNumbers);

		int autoLottoCount = lottos.size() - manualLottoCount;
		resultView.printPurchasedLottosCount(manualLottoCount, autoLottoCount);
		resultView.printPurchasedLottos(lottos);

		List<Integer> winningNumbers = inputView.previousWinningNumber();
		int bonusNumber = inputView.bonusNumber();
		WinningLotto winningLotto = new WinningLotto(Lotto.from(winningNumbers), bonusNumber);

		Statistics statistics = new Statistics(winningLotto, lottos);
		resultView.printStatistics(statistics);
	}
}
