package calculator;

public class ValueNotSplittableException extends IllegalArgumentException{
	static final String VALUE_NOT_SPLITTABLE_ERROR = "null 이나 빈 문자열은 분리할 수 없습니다.";

	public ValueNotSplittableException() {
		super(VALUE_NOT_SPLITTABLE_ERROR);
	}

	public ValueNotSplittableException(String message) {
		super(message);
	}
}
