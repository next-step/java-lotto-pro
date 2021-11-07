package lotto2.domain;

public class Purchase {

	private final static int LOTTO_TICKET_PRICE = 1000;

	public static PositiveNumber calculateCount(Money money) {
		int result = money.toInt() / LOTTO_TICKET_PRICE;
		return PositiveNumber.of(result);
	}

}
