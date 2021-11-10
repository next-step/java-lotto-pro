package controller;

import java.util.Objects;

import model.Lotto;
import model.LottoNumberChoiceRandom;
import model.LottoPurchaseCount;
import model.Lottos;
import model.RewardCalculator;
import view.InputView;
import view.ResultView;

public class LottoGame {
	private final InputView inputView = new InputView();
	private final ResultView resultView = new ResultView();

	public void start() {
		LottoPurchaseCount lottoPurchaseCount = requestPurchasingPrice();
		Lottos purchasedLottos = buyLotto(lottoPurchaseCount);
		inputView.showResponseInputOfPurchaseLottos(purchasedLottos);

		Lotto winningLotto = requestWinningLotto();

		RewardCalculator rewardCalculator = purchasedLottos.calcReward(winningLotto);
		resultView.showResult(lottoPurchaseCount, rewardCalculator);
	}

	private Lotto requestWinningLotto() {
		Lotto winningLotto = null;
		while (Objects.isNull(winningLotto)) {
			inputView.showRequestInputOfWinningNumbers();
			winningLotto = parseInputOfWinningLotto();
		}
		return winningLotto;
	}

	private Lotto parseInputOfWinningLotto() {
		try {
			return new Lotto(inputView.pollInput());
		} catch (RuntimeException e) {
			inputView.showRequestInputExceptionOfWinningNumbers();
			return null;
		}
	}

	private Lottos buyLotto(LottoPurchaseCount lottoPurchaseCount) {
		return new Lottos(new LottoNumberChoiceRandom(), lottoPurchaseCount);
	}

	private LottoPurchaseCount requestPurchasingPrice() {
		LottoPurchaseCount lottoPurchaseCount = null;
		while (Objects.isNull(lottoPurchaseCount)) {
			inputView.showRequestInputOfPurchasePrice();
			lottoPurchaseCount = parseInputOfPurchasePrice();
		}
		return lottoPurchaseCount;
	}

	private LottoPurchaseCount parseInputOfPurchasePrice() {
		try {
			return new LottoPurchaseCount(inputView.pollInput());
		} catch (RuntimeException e) {
			inputView.showRequestInputExceptionOfPurchasedPrice();
			return null;
		}
	}
}
