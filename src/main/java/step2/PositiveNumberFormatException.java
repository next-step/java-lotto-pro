package step2;

public class PositiveNumberFormatException extends RuntimeException {

	public final static String ERROR_MESSAGE = "양수인 값만 허용합니다.";

	public PositiveNumberFormatException() {
		super(ERROR_MESSAGE);
	}
}
