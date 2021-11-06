package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoApplicationController {
	private static final int LOTTO_SALES_PRICE = 1000;
	private PurchaseAmount purchaseAmount;
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
		int purchaseQuantity = purchaseAmount.value() / LOTTO_SALES_PRICE;
		OutputView.printPurchaseQuantity(purchaseQuantity);

		while (purchaseQuantity > 0) {
			lottos.add(new Lotto());
			purchaseQuantity--;
		}




	}
}
