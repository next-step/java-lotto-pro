package lottoservice.exception;

public class UnexpectedMatchException extends RuntimeException{

	public UnexpectedMatchException(String message) {
		super(message);
	}
}
