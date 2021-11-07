package lottoservice.exception;

/**
 * 입력받은 구매 금액이 유효하지 않은 경우 예외
 */

public class InvalidMoneyException extends RuntimeException{

	public InvalidMoneyException(String message) {
		super(message);
	}
}
