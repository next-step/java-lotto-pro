package lotto.domain.exception;

public class OverSpendingMoneyException extends IllegalArgumentException {
	public static final String OVERSPENDING_ERROR = "보유한 자금보다 더 많이 사용 할 수 없습니다.";

	public OverSpendingMoneyException() {
		super(OVERSPENDING_ERROR);
	}
}
