package lotto.domain;

public class LottoPrice {
	private final String INVALID_NUMBER = "0 이상의 수를 입력해주세요.";
	private final String INVALID_ORDER = "로또를 살 수 있는 개수를 초과했습니다.";
	private final int LOTTO_PRICE = 1000;
	private final int ZERO = 0;

	private int money;

	public LottoPrice(int money) {
		validatePositiveNumber(money);
		this.money = money;
	}

	public int availableQuantity() {
		return money / LOTTO_PRICE;
	}

	public int expenses() {
		return availableQuantity() * LOTTO_PRICE;
	}

	public boolean isValidOrder(int quantity) {
		return !(isNegativeNumber(quantity) || lessQuantityThan(quantity));
	}

	private void validatePositiveNumber(int number) {
		if(isNegativeNumber(number)) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}

	private boolean isNegativeNumber(int number) {
		return number < ZERO;
	}

	private boolean lessQuantityThan(int quantity) {
		return quantity > availableQuantity();
	}
}
