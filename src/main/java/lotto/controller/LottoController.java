package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
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
		Lottos lottos = new Lottos(inputPurchaseAmount);
		resultView.lottosResult(lottos);

		String input = inputView.prevWinNumbers();
		WinningLotto winningLotto = new WinningLotto(input);

		WinningStatistics winningStatistics = new WinningStatistics(winningLotto);
		resultView.winStatisticsResult(winningStatistics, lottos);
	}
}


