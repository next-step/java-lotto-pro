package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStatistics;
import lotto.util.InputSplitter;
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
		WinNumbers winNumbers = new WinNumbers(input);

		WinStatistics winStatistics = new WinStatistics(lottos, winNumbers);
		resultView.winStatisticsResult(winStatistics);
	}
}


