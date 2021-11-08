package calculator;

public class ValuesNotConvertibleException extends IllegalArgumentException {
	static final String VALUES_NOT_CONVERTABLE_ERROR = "null 이나 빈 배열은 변환 할 수 없습니다.";

	public ValuesNotConvertibleException() {
		super(VALUES_NOT_CONVERTABLE_ERROR);
	}

	public ValuesNotConvertibleException(String message) {
		super(message);
	}
}
