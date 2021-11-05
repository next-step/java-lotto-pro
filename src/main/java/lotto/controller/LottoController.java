package lotto.controller;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.ViewMessage.*;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoCount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.generator.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	private final InputView inputView;
	private final ResultView resultView;

	public LottoController() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	public void play() {
		Money money = inputView.inputMoney();
		LottoCount purchasedCount = calculatePurchasedLottoCount(money);
		LottoCount customLottoCount = inputView.inputCustomLottoCount(purchasedCount);

		Lottos lottos = purchaseLottos(purchasedCount, customLottoCount);
		LottoNumbers lastWinningNumbers = LottoNumbers.of(inputLastWinningNumbers());
		LottoNumber bonusNumber = inputView.inputBonusNumber(lastWinningNumbers);

		WinningStatistics winningStatistics = WinningStatistics.createBy(lottos, lastWinningNumbers, bonusNumber, money);
		winningStatistics.buildStatistics();

		resultView.printWinningStatistics(winningStatistics);
	}

	public Lottos purchaseLottos(LottoCount purchasedCount, LottoCount customLottoCount) {
		Lottos totalLottos = Lottos.of(createCustomAndAutoLottos(purchasedCount, customLottoCount));
		resultView.printLottos(totalLottos);

		return totalLottos;
	}

	private List<Lotto> createCustomAndAutoLottos(LottoCount purchasedCount, LottoCount customLottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		lottos.addAll(createCustomLottos(customLottoCount));
		lottos.addAll(createAutoLottos(LottoCount.minus(purchasedCount, customLottoCount)));

		return lottos;
	}

	private List<Lotto> createCustomLottos(LottoCount customLottoCount) {
		System.out.println(CUSTOM_LOTTO_INPUT_GUIDE_MESSAGE);
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < customLottoCount.getValue(); i++) {
			LottoNumbers lottoNumbers = LottoNumbers.of(inputView.inputLottoNumbers(CUSTOM_LOTTO_INPUT_GUIDE_MESSAGE));
			lottos.add(Lotto.of(lottoNumbers));
		}

		return lottos;
	}

	private LottoCount calculatePurchasedLottoCount(Money money) {
		return LottoCount.of(money.getValue() / LOTTO_PRICE);
	}

	private List<Lotto> createAutoLottos(LottoCount purchasedCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < purchasedCount.getValue(); i++) {
			LottoNumbers lottoNumbers = LottoNumbers.createBy(new LottoNumberGenerator());
			lottos.add(Lotto.of(lottoNumbers));
		}

		return lottos;
	}

	private List<Integer> inputLastWinningNumbers() {
		System.out.println(LAST_WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
		return inputView.inputLottoNumbers(LAST_WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
	}
}
