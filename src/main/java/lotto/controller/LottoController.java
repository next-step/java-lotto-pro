package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void lotto() {
		generateLottoResult(winningLottoNumberGenerator(), generateLotto());
	}

	private Lottos generateLotto() {
		Lottos lottos = lottoGenerator();
		OutputView.printCompletePurchaseLotto(lottos);
		OutputView.printLottoNumbers(lottos);

		return lottos;
	}

	private Lottos lottoGenerator() {
		try {
			return new Lottos(new LottoGenerator(InputView.inputMoneyPurchaseLotto()));
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

	private void generateLottoResult(WinningLottoNumbers winningLottoNumbers, Lottos lottos) {
		OutputView.printResultHead();
		LottoResult lottoResult = new LottoResult(winningLottoNumbers, lottos);
		OutputView.printResultLottoList(lottoResult);
		OutputView.printYieldResult(lottoResult);
	}
}
