package stringaddcalculator.exception;

public class NotNumberException extends RuntimeException {
	protected static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닌 문자가 입력되었습니다.";

	public NotNumberException() {
		super(NOT_NUMBER_EXCEPTION_MESSAGE);
	}
}
