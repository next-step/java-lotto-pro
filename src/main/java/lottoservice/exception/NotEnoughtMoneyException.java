package lottoservice.exception;

/**
 * 구매 금액이 단위 가격 미만인 경우 예외
 */

public class NotEnoughtMoneyException extends InvalidMoneyException {
	public NotEnoughtMoneyException(String message) {
		super(message);
	}
}
