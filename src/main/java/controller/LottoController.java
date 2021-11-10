package controller;

import java.util.ArrayList;
import java.util.List;

import model.BonusBall;
import model.Count;
import model.LastWeekWinningNumber;
import model.Lotto;
import model.Lottos;
import model.Money;
import model.Purchase;
import model.PurchaseCount;
import view.InputView;
import view.ResultView;

public class LottoController {

	public void start() {
		Money money = inputForPurchaseAmountUntilValid();
		PurchaseCount manualPurchaseCount = inputForManualPurchaseCountUntilValid(money);
		Lottos manualLottos = inputForManualLottos(manualPurchaseCount);

		Purchase purchase = Purchase.of(money, manualPurchaseCount, manualLottos);
		ResultView.printPurchaseInfoMessage(purchase);
		Lottos lottos = Lottos.from(purchase);
		ResultView.printLottoNumbers(lottos);

		LastWeekWinningNumber lastWeekWinningNumber = inputForLastWeekWinningNumber();
		BonusBall bonusBall = inputForBonusBallUntilValid(lastWeekWinningNumber);

		lastWeekWinningNumber.updateBonusBall(bonusBall);
		ResultView.printWinningStatisticsMessage(lottos.matchResult(lastWeekWinningNumber), money);
	}

	private static Money inputForPurchaseAmountUntilValid() {
		String money = InputView.printPurchaseAmountMessageAndInput();
		while (!Money.validate(money)) {
			money = InputView.reInputIfInvalidPurchaseAmount();
		}

		return Money.of(money);
	}

	private static PurchaseCount inputForManualPurchaseCountUntilValid(Money money) {
		String manualPurchaseCount = InputView.printManualPurchaseCountMessageAndInput();
		while (isNotValidPurchaseCount(money, manualPurchaseCount)) {
			manualPurchaseCount = InputView.reInputIfInvalidManualPurchaseCount();
		}

		return PurchaseCount.from(manualPurchaseCount);
	}

	private static boolean isNotValidPurchaseCount(Money money, String manualPurchaseCount) {
		return !(PurchaseCount.validate(manualPurchaseCount)
			&& money.isPurchaseable(Money.total(Lotto.COST, Count.from(manualPurchaseCount))));
	}

	private static Lottos inputForManualLottos(PurchaseCount count) {
		InputView.printManualLottoNumberMessageAndInput();

		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < count.getValue(); i++) {
			lottos.add(inputForManualLottoNumberUntilValid());
		}

		return Lottos.of(lottos);
	}

	private static Lotto inputForManualLottoNumberUntilValid() {
		String numbers = InputView.input();
		while (!Lotto.validate(numbers)) {
			numbers = InputView.reInputIfInvalidLottoNumber();
		}

		return Lotto.of(numbers);
	}

	private static LastWeekWinningNumber inputForLastWeekWinningNumber() {
		String lastWeekWinningNumber = InputView.printLastWeekWinningNumberMessageAndInput();
		while (!LastWeekWinningNumber.validate(lastWeekWinningNumber)) {
			lastWeekWinningNumber = InputView.reInputIfInvalidLottoNumber();
		}

		return LastWeekWinningNumber.of(lastWeekWinningNumber);
	}

	private static BonusBall inputForBonusBallUntilValid(LastWeekWinningNumber lastWeekWinningNumber) {
		String bonusBall = InputView.printBonusBallMessageAndInput();
		while (isNotValidLastWeekWinningNumber(lastWeekWinningNumber, bonusBall)) {
			bonusBall = InputView.reInputIfInvalidBonusBall();
		}

		return BonusBall.from(bonusBall);
	}

	private static boolean isNotValidLastWeekWinningNumber(LastWeekWinningNumber lastWeekWinningNumber,
		String bonusBall) {
		return !(BonusBall.validate(bonusBall) && lastWeekWinningNumber.isNotContain(bonusBall));
	}

}
