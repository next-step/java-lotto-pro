package lottoservice.exception;

/**
 * 중복된 로또 번호를 입력한 경우 예외
 */

public class DuplicateLottoNumberException extends InvalidLottoFormatException {

	public DuplicateLottoNumberException(String message) {
		super(message);
	}
}
