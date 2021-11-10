package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.exception.LottoException;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void lotto() {
		generateLottoResult(generateLotto(), winningLottoNumberGenerator());
	}

	private Lottos generateLotto() {
		Lottos lottos = lottoGenerator();
		OutputView.printCompletePurchaseLotto(lottos);
		OutputView.printLottoNumbers(lottos);

		return lottos;
	}

	private Lottos lottoGenerator() {
		try {
			Money inputMoney = Money.from(InputView.inputMoneyPurchaseLotto());
			LottoGenerator lottoGenerator = LottoGenerator.of(inputMoney, generatePurchaseLotto());
			return Lottos.of(lottoGenerator.generateInputLottoNumbers(), lottoGenerator.generateRandomLottoNumbers());
		} catch (LottoException lottoException) {
			OutputView.printErrorMessage(lottoException);
			return lottoGenerator();
		}
	}

	private List<String> generatePurchaseLotto() {
		String count = InputView.inputPurchaseLottoCount();
		InputView.inputPurchaseLottoNumberMent();
		return Stream.generate(InputView::inputPurchaseLottoNumber)
			.limit(Integer.parseInt(count))
			.collect(Collectors.toList());
	}

	private WinningLottoNumbers winningLottoNumberGenerator() {
		try {
			return WinningLottoNumbers.of(InputView.inputWinningLottoNumber(), InputView.inputBonusLottoNumber());
		} catch (LottoException lottoException) {
			OutputView.printErrorMessage(lottoException);
			return winningLottoNumberGenerator();
		}
	}

	private void generateLottoResult(Lottos lottos, WinningLottoNumbers winningLottoNumbers) {
		OutputView.printResultHead();
		LottoResult lottoResult = LottoResult.of(winningLottoNumbers, lottos);
		OutputView.printResultLottoList(lottoResult);
		OutputView.printYieldResult(lottoResult);
	}
}
