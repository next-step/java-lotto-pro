package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class LottoApplicationController {
	private static final int PURCHASE_FINISH = 0;
	private PurchaseAmount purchaseAmount;
	private WinningNumbers winningNumbers;
	private LottoStatistics lottoStatistics = new LottoStatistics();
	private List<Lotto> lottos = new ArrayList<>();

	public String validatePurchaseAmount(String purchaseAmount) {
		try {
			this.purchaseAmount = new PurchaseAmount(purchaseAmount);
		} catch (IllegalArgumentException exception) {
			return exception.getMessage();
		}
		return "";
	}

	public void purchaseLotto() {
		int purchaseQuantity = getPurchaseQuantity();
		while (continuePurchase(purchaseQuantity)) {
			// lottos.add(new Lotto(new LottoNumbers(LottoShop.sell())));
			purchaseQuantity--;
		}
	}

	private boolean continuePurchase(int purchaseQuantity) {
		return purchaseQuantity > PURCHASE_FINISH;
	}

	public String validateWinningNumbers(String winningNumbers) {
		try {
			this.winningNumbers = new WinningNumbers(winningNumbers);
		} catch (IllegalArgumentException exception) {
			return exception.getMessage();
		}
		return "";
	}

	public LottoStatistics recorde() {
		for (Lotto lotto : lottos) {
			lottoStatistics.record(lotto.countMatchNumber(winningNumbers));
		}
		return lottoStatistics;
	}

	public int getPurchaseQuantity() {
		return purchaseAmount.purchase();
	}

	public List<Lotto> getLotts() {
		return lottos;
	}
}
