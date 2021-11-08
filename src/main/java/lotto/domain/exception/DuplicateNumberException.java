package lotto.domain.exception;

public class DuplicateNumberException extends IllegalArgumentException {
	private static final String DUPLICATED_NUMBER_ERROR = "중복된 값이 포함되어 있습니다.";

	public DuplicateNumberException() {
		super(DUPLICATED_NUMBER_ERROR);
	}
}
