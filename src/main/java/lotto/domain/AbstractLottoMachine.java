package lotto.domain;

public abstract class AbstractLottoMachine {
	public static final int LOTTO_PRICE = 1000;

	public int getLottoCount(Money money) {
		return money.divide(LOTTO_PRICE);
	}
}
