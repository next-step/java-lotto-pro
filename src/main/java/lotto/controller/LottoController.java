package lotto.controller;

import java.util.List;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.PurchaseLottos;
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
		try {
			Amount purchaseAmount = Amount.from(inputView.purchaseAmount());
			PurchaseLottos purchaseLottos = new PurchaseLottos(purchaseAmount);

			List<String> manualLottoNumbers = inputView.manualLottoNumbers();
			Lottos manualLottos = purchaseLottos.purchaseManualLottos(manualLottoNumbers);
			Lottos randomLottos = purchaseLottos.purchaseRandomLottos();

			resultView.lottosResult(manualLottos, randomLottos);
			Lottos lottos = manualLottos.concat(randomLottos);

			String winNumbersInput = inputView.prevWinNumbers();
			int bonusBallInput = inputView.bonusBall();
			WinningLotto winningLotto = WinningLotto.from(winNumbersInput, bonusBallInput);

			resultView.winStatisticsResult(lottos, winningLotto, purchaseAmount);
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println("프로그램이 종료되었습니다: " + e.getMessage());
		}
	}
}


