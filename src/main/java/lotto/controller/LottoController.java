package lotto.controller;

import java.util.List;

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
		Amount purchaseAmount = Amount.from(inputView.purchaseAmount());
		List<String> manualLottoNumbers = inputView.manualLottoNumbers();

		Lottos manualLottos = Lottos.purchaseManualLottos(manualLottoNumbers);
		Lottos randomLottos = Lottos.purchaseRandomLottos(
			purchaseAmount.sub(Amount.from(manualLottos.getQuantity().getInt() * 1000L)));

		resultView.lottosResult(manualLottos, randomLottos);

		Lottos lottos = manualLottos.concat(randomLottos);

		String winNumbersInput = inputView.prevWinNumbers();
		String bonusBallInput = inputView.bonusBall();
		WinningLotto winningLotto = WinningLotto.from(winNumbersInput, bonusBallInput);

		resultView.winStatisticsResult(lottos, winningLotto, purchaseAmount);
	}
}


