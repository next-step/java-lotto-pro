package lottoservice.exception;

/**
 * 유효하지 않은 로또 번호 값에 대한 예외
 */

public class InvalidLottoFormatException extends RuntimeException {

	public InvalidLottoFormatException(String message) {
		super(message);
	}

}
