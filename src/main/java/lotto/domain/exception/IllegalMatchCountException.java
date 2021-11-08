package lotto.domain.exception;

public class IllegalMatchCountException extends IllegalArgumentException {
	private static final String MATCH_COUNT_NOT_CORRECT_ERROR = "일치하는 숫자의 개수가 올바르지 않습니다.";

	public IllegalMatchCountException() {
		super(MATCH_COUNT_NOT_CORRECT_ERROR);
	}
}
