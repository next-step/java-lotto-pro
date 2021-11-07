package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberFactory;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplicationController {
	private static final int PURCHASE_FINISH = 0;
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
		}
		return false;
	}

	public void printPurchaseQuantity() {
		int purchaseQuantity = purchaseAmount.purchase();
		OutputView.printPurchaseQuantity(purchaseQuantity);

		while (continuePurchase(purchaseQuantity)) {
			lottos.add(new Lotto(new LottoNumbers(LottoNumberFactory.create())));
			purchaseQuantity--;
		}
	}

	private boolean continuePurchase(int purchaseQuantity) {
		return purchaseQuantity > PURCHASE_FINISH;
	}

	public void printPurchasedLottoNumbers() {
		for (Lotto lotto : lottos) {
			OutputView.printPurchasedLottoNumbers(lotto.getLottoNumbersStringValues());
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
