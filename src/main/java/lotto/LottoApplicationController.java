package lotto;

public class LottoApplicationController {
	private PurchaseAmount purchaseAmount;

	public boolean enterPurchaseAmount() {
		try {
			purchaseAmount = new PurchaseAmount(InputView.enterPurchaseAmount());
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return true;
		}
		return false;
	}
}
