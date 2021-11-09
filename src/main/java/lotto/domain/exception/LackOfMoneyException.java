package lotto.domain.exception;

public class LackOfMoneyException extends IllegalArgumentException {
	private static final String MINIMUM_PRICE_REQUIRED_ERROR = "구매 금액은 1000원 이상이어야 합니다.";

	public LackOfMoneyException() {
		super(MINIMUM_PRICE_REQUIRED_ERROR);
	}

	public LackOfMoneyException(String message) {
		super(message);
	}
}
