package lotto;

public class LottoApplication {

	public static void main(String[] args) {
		Repeater.init();
		LottoApplicationController lottoApplicationController = new LottoApplicationController();

		while (Repeater.isContinue()) {
			Repeater.set(lottoApplicationController.enterPurchaseAmount());
		}

	}
}
