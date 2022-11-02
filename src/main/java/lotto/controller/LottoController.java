package lotto.controller;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	private final InputView inputView;
	private final ResultView resultView;

	public LottoController(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void run() {
		String inputPurchaseAmount = inputView.purchaseAmount();
		Amount purchaseAmount = Amount.from(inputPurchaseAmount);
		Lottos lottos = Lottos.purchase(purchaseAmount);
		resultView.lottosResult(lottos);

		String input = inputView.prevWinNumbers();
		WinningLotto winningLotto = new WinningLotto(input);

		resultView.winStatisticsResult(lottos, winningLotto, purchaseAmount);
	}
}


