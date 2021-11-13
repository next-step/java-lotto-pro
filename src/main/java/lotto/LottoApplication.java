package lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.console.Repeater;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.console.InputView;
import lotto.console.OutputView;
import lotto.domain.WinningLotto;

public class LottoApplication {

	public static void main(String[] args) {
		Repeater.init();
		Money purchaseAmount = null;
		while (Repeater.isContinue()) {
			purchaseAmount = InputView.enterPurchaseAmount();
			Repeater.set(purchaseAmount);
		}
		OutputView.newLine();

		Repeater.init();
		Money manualPurchaseAmount = null;
		while (Repeater.isContinue()) {
			manualPurchaseAmount = InputView.enterManualLottoPurchaseQuantity(purchaseAmount);
			Repeater.set(manualPurchaseAmount);
		}
		OutputView.newLine();

		Repeater.init();
		InputView.enterManualLottoNumbersHeader();
		Lottos manualLottos = IntStream.range(0, manualPurchaseAmount.getPurchaseQuantity(LottoShop.LOTTO_PRICE))
			.mapToObj(ignore -> InputView.enterManualLottoNumbersBody())
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
		OutputView.newLine();

		Money autoPurchaseAmount = purchaseAmount.deduct(manualPurchaseAmount);
		Lottos autoLottos = LottoShop.sell(autoPurchaseAmount);
		Lottos lottos = manualLottos.addAll(autoLottos);

		OutputView.printPurchaseQuantity(manualPurchaseAmount.getPurchaseQuantity(LottoShop.LOTTO_PRICE)
			, autoPurchaseAmount.getPurchaseQuantity(LottoShop.LOTTO_PRICE));
		OutputView.printPurchasedLottoNumbers(lottos.getLottos());
		OutputView.newLine();

		String winningNumbers = "";
		Repeater.init();
		while (Repeater.isContinue()) {
			winningNumbers = InputView.enterWinningNumbers();
			Repeater.set(winningNumbers);
		}

		int bonusBallNumber = 0;
		Repeater.init();
		while (Repeater.isContinue()) {
			bonusBallNumber = InputView.enterBonusBallNumber(winningNumbers);
			Repeater.set(bonusBallNumber);
		}
		OutputView.newLine();
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBallNumber);

		LottoResult lottoResult = lottos.createLottoResult(winningLotto);
		OutputView.printLottoStatisticsHeader();
		OutputView.printLottoStatisticsBody(lottoResult);
	}
}
