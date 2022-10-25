package stringaddcalculator.exception;

public class NegativeNumberException extends RuntimeException {
	protected static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수를 입력할 수 없습니다.";

	public NegativeNumberException() {
		super(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
	}
}
