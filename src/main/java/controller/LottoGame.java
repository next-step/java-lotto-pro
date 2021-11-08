package controller;

import model.Lotto;
import model.LottoNumberChoiceRandom;
import model.LottoPurchaseCount;
import model.Lottos;
import model.RewardCalculator;
import view.InputView;
import view.ResultView;

public class LottoGame {

	public void start() {
		InputView inputView = new InputView();
		inputView.showRequestInputOfPurchasePrice();
		LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(inputView.pollInput());
		Lottos purchasedLottos = new Lottos(new LottoNumberChoiceRandom(), lottoPurchaseCount);
		inputView.showResponseInputOfPurchaseLottos(purchasedLottos);

		inputView.showRequestInputOfWinningNumbers();
		Lotto winningLotto = new Lotto(inputView.pollInput());

		RewardCalculator rewardCalculator = purchasedLottos.calcReward(winningLotto);
		ResultView resultView = new ResultView();
		resultView.showResult(lottoPurchaseCount, rewardCalculator);
	}
}
