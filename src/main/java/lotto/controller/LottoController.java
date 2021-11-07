package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void lotto() {
		generateLottoResult(generateLotto(), winningLottoNumberGenerator());
	}

	private LottoGenerator generateLotto() {
		LottoGenerator lottoGenerator = lottoGenerator();
		OutputView.printCompletePurchaseLotto(lottoGenerator);
		OutputView.printLottoNumbers(lottoGenerator);

		return lottoGenerator;
	}

	private LottoGenerator lottoGenerator() {
		try {
			return new LottoGenerator(InputView.inputMoneyPurchaseLotto());
		} catch (IllegalArgumentException illegalArgumentException) {
			return lottoGenerator();
		}
	}

	private WinningLottoNumbers winningLottoNumberGenerator() {
		try {
			return new WinningLottoNumbers(InputView.inputWinningLottoNumber());
		} catch (IllegalArgumentException illegalArgumentException) {
			return winningLottoNumberGenerator();
		}
	}

	private void generateLottoResult(LottoGenerator lottoGenerator, WinningLottoNumbers winningLottoNumbers) {
		OutputView.printResultHead();
		LottoResult lottoResult = new LottoResult(winningLottoNumbers, lottoGenerator);
		OutputView.printResultLottoList(lottoResult);
		OutputView.printYieldResult(lottoResult);
	}
}
