package lotto.domain.exception;

public class IllegalMoneyException extends IllegalArgumentException {
	private static final String NO_MONEY_ERROR = "구입 자금은 0원 보다 작을 수 없습니다.";

	public IllegalMoneyException() {
		super(NO_MONEY_ERROR);
	}
}
