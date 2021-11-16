package controller;

import java.util.Objects;

import model.Lotto;
import model.LottoNumber;
import model.LottoNumberChoiceRandom;
import model.LottoPurchaseCount;
import model.Lottos;
import model.RewardCalculator;
import view.InputView;
import view.ResultView;

public class LottoGame {
	public void start() {
		LottoPurchaseCount lottoPurchaseCount = requestPurchasingPrice();
		Lottos purchasedLottos = buyLotto(lottoPurchaseCount);
		InputView.showResponseInputOfPurchaseLottos(purchasedLottos);

		Lotto winningLotto = requestWinningLotto();
		LottoNumber bonusNumber = requestBonusNumber();

		RewardCalculator rewardCalculator = purchasedLottos.calcReward(winningLotto, bonusNumber);
		ResultView.showResult(lottoPurchaseCount, rewardCalculator);
	}

	private LottoNumber requestBonusNumber() {
		LottoNumber bonusNumber = null;
		while (Objects.isNull(bonusNumber)) {
			InputView.showRequestInputOfBonusNumber();
			bonusNumber = parseInputOfBonusNumber();
		}
		return bonusNumber;
	}

	private Lotto requestWinningLotto() {
		Lotto winningLotto = null;
		while (Objects.isNull(winningLotto)) {
			InputView.showRequestInputOfWinningNumbers();
			winningLotto = parseInputOfWinningLotto();
		}
		return winningLotto;
	}

	private Lotto parseInputOfWinningLotto() {
		try {
			return new Lotto(InputView.pollInput());
		} catch (RuntimeException e) {
			InputView.showRequestInputExceptionOfWinningNumbers();
			return null;
		}
	}

	private Lottos buyLotto(LottoPurchaseCount lottoPurchaseCount) {
		return new Lottos(new LottoNumberChoiceRandom(), lottoPurchaseCount);
	}

	private LottoPurchaseCount requestPurchasingPrice() {
		LottoPurchaseCount lottoPurchaseCount = null;
		while (Objects.isNull(lottoPurchaseCount)) {
			InputView.showRequestInputOfPurchasePrice();
			lottoPurchaseCount = parseInputOfPurchasePrice();
		}
		return lottoPurchaseCount;
	}

	private LottoPurchaseCount parseInputOfPurchasePrice() {
		try {
			return new LottoPurchaseCount(InputView.pollInput());
		} catch (RuntimeException e) {
			InputView.showRequestInputExceptionOfPurchasedPrice();
			return null;
		}
	}

	private LottoNumber parseInputOfBonusNumber() {
		try {
			return new LottoNumber(InputView.pollInput());
		} catch (RuntimeException e) {
			InputView.showRequestInputExceptionOfBonusNumber();
			return null;
		}
	}
}
