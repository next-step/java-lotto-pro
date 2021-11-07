package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoApplicationController {
	private static final int PURCHASE_FINISH = 0;
	private static final int LOTTO_PRICE = 1000;
	private PurchaseAmount purchaseAmount;
	private WinningNumbers winningNumbers;
	private LottoStatistics lottoStatistics = new LottoStatistics();
	private List<Lotto> lottos = new ArrayList<>();

	public boolean enterPurchaseAmount() {
		try {
			purchaseAmount = new PurchaseAmount(InputView.enterPurchaseAmount());
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return true;
		} catch (IllegalStateException exception) {
			OutputView.printMessage(exception.getMessage());
			return true;
		}
		return false;
	}

	public void printPurchaseQuantity() {
		int purchaseQuantity = purchaseAmount.value() / LOTTO_PRICE;
		OutputView.printPurchaseQuantity(purchaseQuantity);

		while (continuePurchase(purchaseQuantity)) {
			lottos.add(new Lotto());
			purchaseQuantity--;
		}

		OutputView.newLine();
	}

	private boolean continuePurchase(int purchaseQuantity) {
		if (purchaseQuantity > PURCHASE_FINISH) {
			return true;
		}
		return false;
	}

	public void printPurchasedLottoNumbers() {
		for (Lotto lotto : lottos) {
			OutputView.printMessage(lotto.getLottoNumbersStringValues());
		}

		OutputView.newLine();
	}

	public boolean enterWinningNumbers() {
		try {
			winningNumbers = new WinningNumbers(InputView.enterWinningNumbers());
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return true;
		}
		OutputView.newLine();
		return false;
	}

	public void printLottoStatistics() {
		OutputView.printLottoStatisticsHeader();

		for (Lotto lotto : lottos) {
			lottoStatistics.record(lotto.countMatchNumber(winningNumbers));
		}
		OutputView.printLottoStatisticsBody(lottoStatistics.getWinningRecord(), lottoStatistics.getProfitRate());
	}
}
