package lotto.model;

public class Money {
	private static final int LOTTO_PRICE = 1000;

	private final int money;

	public Money(String strMoney) {
		money = Integer.parseUnsignedInt(strMoney);
	}

	/**
	 * 구매 가능한 로또 개수 반환
	 * @return 구매 가능한 로또 개수
	 */
	public int getNumberOfPurchaseAvailable() {
		return money / LOTTO_PRICE;
	}

	/**
	 * 실제 사용한 금액 반환
	 * @return 사용한 금액 
	 */
	public int getUsedMoney() {
		return (money / LOTTO_PRICE) * LOTTO_PRICE;
	}
}
