package lottoservice.exception;

/**
 * 구매 금액 입력값에 숫자가 아닌 문자가 있는 경우
 */

public class InvalidNumberFormatMoneyException extends InvalidMoneyException {

	public InvalidNumberFormatMoneyException(String message) {
		super(message);
	}

}
