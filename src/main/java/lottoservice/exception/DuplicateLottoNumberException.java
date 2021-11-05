package lottoservice.exception;

public class DuplicateLottoNumberException extends InvalidLottoFormatException {

	public DuplicateLottoNumberException(String message) {
		super(message);
	}
}
