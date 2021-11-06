package lotto.model;

public class LotteryWallet {
	private Money budget;
	private Lottos lottos;

	public LotteryWallet(String strMoney) {
		budget = new Money(strMoney);
		int possiblePurchase = budget.getNumberOfPurchaseAvailable();
		lottos = new Lottos(possiblePurchase);
	}

	public int numberOfPurchasedLotto() {
		return lottos.size();
	}
}
