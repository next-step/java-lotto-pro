package controller;

import java.util.Objects;

import model.Lotto;
import model.LottoNumber;
import model.LottoNumberChoiceManual;
import model.LottoNumberChoiceRandom;
import model.LottoNumberChoiceStrategy;
import model.LottoPurchaseCount;
import model.LottoPurchasePrice;
import model.Lottos;
import model.RewardCalculator;
import view.InputView;
import view.ResultView;

public class LottoGame {
	public void start() {
		LottoPurchasePrice lottoPurchasePrice = requestPurchasingPrice();
		LottoPurchaseCount totalLottoPurchaseCount = lottoPurchasePrice.toPurchaseCount();
		LottoPurchaseCount manualLottoPurchaseCount = requestPurchasingManualLottoCount(totalLottoPurchaseCount);
		LottoPurchaseCount autoLottoPurchaseCount = new LottoPurchaseCount(totalLottoPurchaseCount.get() - manualLottoPurchaseCount.get());

		InputView.showRequestInputOfManualLottos();
		Lottos purchasedManualLottos = buyLotto(new LottoNumberChoiceManual(), manualLottoPurchaseCount);
		Lottos purchasedAutoLottos = buyLotto(new LottoNumberChoiceRandom(), autoLottoPurchaseCount);
		showBuyingLottosResult(manualLottoPurchaseCount, autoLottoPurchaseCount, purchasedManualLottos, purchasedAutoLottos);

		Lotto winningLotto = requestWinningLotto();
		LottoNumber bonusNumber = requestBonusNumber();

		showRewardResult(lottoPurchasePrice, purchasedManualLottos, purchasedAutoLottos, winningLotto, bonusNumber);
	}

	private void showRewardResult(LottoPurchasePrice lottoPurchasePrice, Lottos purchasedManualLottos,
		Lottos purchasedAutoLottos, Lotto winningLotto, LottoNumber bonusNumber) {
		RewardCalculator rewardCalculator = purchasedManualLottos.calcReward(winningLotto, bonusNumber)
			.sum(purchasedAutoLottos.calcReward(winningLotto, bonusNumber));
		ResultView.showResult(lottoPurchasePrice, rewardCalculator);
	}

	private void showBuyingLottosResult(LottoPurchaseCount manualLottoPurchaseCount, LottoPurchaseCount autoLottoPurchaseCount,
		Lottos purchasedManualLottos, Lottos purchasedAutoLottos) {
		InputView.showResponseInputOfPurchaseLottosTitle(manualLottoPurchaseCount, autoLottoPurchaseCount);
		InputView.showResponseInputOfPurchaseLottos(purchasedManualLottos);
		InputView.showResponseInputOfPurchaseLottos(purchasedAutoLottos);
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

	private Lottos buyLotto(LottoNumberChoiceStrategy lottoNumberChoiceStrategy,
		LottoPurchaseCount lottoPurchaseCount) {
		return new Lottos(lottoNumberChoiceStrategy, lottoPurchaseCount);
	}

	private LottoPurchaseCount requestPurchasingManualLottoCount(LottoPurchaseCount totalLottoPurchaseCount) {
		LottoPurchaseCount lottoPurchaseCount = null;
		while (Objects.isNull(lottoPurchaseCount)) {
			InputView.showRequestInputOfManualLottoPurchaseCount();
			lottoPurchaseCount = parseInputOfManualLottoPurchaseCount(totalLottoPurchaseCount);
		}
		return lottoPurchaseCount;
	}

	private LottoPurchaseCount parseInputOfManualLottoPurchaseCount(LottoPurchaseCount totalLottoPurchaseCount) {
		try {
			int parsedManualPurchasedCount = Integer.parseInt(InputView.pollInput());
			if (totalLottoPurchaseCount.isLessThan(parsedManualPurchasedCount)) {
				InputView.showRequestInputExceptionOfTotalPurchaseCountLessThanManual();
				return null;
			}
			return new LottoPurchaseCount(parsedManualPurchasedCount);
		} catch (RuntimeException e) {
			InputView.showRequestInputExceptionOfManualLottoPurchaseCount();
			return null;
		}
	}

	private LottoPurchasePrice requestPurchasingPrice() {
		LottoPurchasePrice lottoPurchaseCount = null;
		while (Objects.isNull(lottoPurchaseCount)) {
			InputView.showRequestInputOfPurchasePrice();
			lottoPurchaseCount = parseInputOfPurchasePrice();
		}
		return lottoPurchaseCount;
	}

	private LottoPurchasePrice parseInputOfPurchasePrice() {
		try {
			return new LottoPurchasePrice(Integer.parseInt(InputView.pollInput()));
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
