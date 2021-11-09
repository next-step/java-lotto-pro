package calculator;

public class NumberOutOfRangeException extends RuntimeException {

	static final String OUT_OF_MINIMUM_NUMBER_RANGE_ERROR = "0보다 작은 수는 사용 할 수 없습니다.";

	public NumberOutOfRangeException() {
		super(OUT_OF_MINIMUM_NUMBER_RANGE_ERROR);
	}

	public NumberOutOfRangeException(String message) {
		super(message);
	}
}
