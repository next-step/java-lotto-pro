package lotto.domain;

public class LottoPurchase {

	private static final int LOTTO_PRICE = 1000;

	public static int getLottoCount(int money) {
		return money / LOTTO_PRICE;
	}

}
