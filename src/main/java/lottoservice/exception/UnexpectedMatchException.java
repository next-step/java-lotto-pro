package lottoservice.exception;

/**
 * 당첨번호와 티켓의 비교 과정에서 로직상 발생할 수 없는 Null이 발생한 경우 예외
 */

public class UnexpectedMatchException extends RuntimeException{

	public UnexpectedMatchException(String message) {
		super(message);
	}
}
