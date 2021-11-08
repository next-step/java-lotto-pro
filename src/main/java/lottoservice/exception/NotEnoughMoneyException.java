package lottoservice.exception;

/**
 * 구매 금액이 단위 가격 미만인 경우 예외
 */

public class NotEnoughMoneyException extends InvalidMoneyException {

	public NotEnoughMoneyException(String message) {
		super(message);
	}

}
